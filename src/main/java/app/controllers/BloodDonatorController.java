package app.controllers;

import app.entities.Address;
import app.entities.BloodDonationCenter;
import app.models.bindingModels.BloodDonatorRegistrationModel;
import app.models.viewModels.BloodDonationViewModel;
import app.models.viewModels.BloodDonatorViewModel;
import app.services.BloodDonationCenterService;
import app.services.BloodDonationService;
import app.services.BloodDonatorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;

@Controller
public class BloodDonatorController {
    @Autowired
    private BloodDonatorService bloodDonatorService;
    @Autowired
    private BloodDonationService bloodDonationService;
    @Autowired
    private BloodDonationCenterService bloodDonationCenterService;

    @GetMapping("/blood-donator-register")
    private String registrationDonatorForm(@ModelAttribute BloodDonatorRegistrationModel bloodDonatorRegistrationModel, Model model) {

        List<BloodDonationCenter> bloodDonationCenters = this.bloodDonationCenterService.findAll();
        model.addAttribute("bloodDonationCenters", bloodDonationCenters);

        return "blood-donators/blood-donator-register";
    }

    @PostMapping("/blood-donator-register")
    private String registrationDonatorForm(@Valid @ModelAttribute BloodDonatorRegistrationModel bloodDonatorRegistrationModel, BindingResult result, Model model, String bloodDonationCenterName) {
        List<FieldError> fieldErrors = result.getFieldErrors();
        if (result.hasErrors()) {
            List<BloodDonationCenter> bloodDonationCenters = this.bloodDonationCenterService.findAll();
            model.addAttribute("bloodDonationCenters", bloodDonationCenters);
            for (FieldError err : fieldErrors) {
                String field = err.getField();
                String error = err.getDefaultMessage().toString();
                String param = field + "Error";
                model.addAttribute(param, error);

            }
            return "blood-donators/blood-donator-register";
        }

        this.bloodDonatorService.save(bloodDonatorRegistrationModel, bloodDonationCenterName);
        return "successfully-completed";
    }

    @GetMapping("/findAll")
    public String findAll(Model model) {
        List<BloodDonatorViewModel> bloodDonatorList = this.bloodDonatorService.findAll();
        model.addAttribute("bloodDonatorList", bloodDonatorList);
        return "findAll";
    }

    @GetMapping("/successfully-completed")
    public String secc() {
        return "successfully-completed";
    }

    @GetMapping("/find-blood-donator-by-first-name")
    public String findByFirstName() {
        return "blood-donators/find-blood-donator-by-first-name";
    }

    @PostMapping("/find-blood-donator-by-first-name")
    public String findDonatorByFirstName(Model model, String firstName) {
        List<BloodDonatorViewModel> bloodDonatorList = this.bloodDonatorService.findByFirstName(firstName);
        if(bloodDonatorList.isEmpty()){
            return "blood-donators/find-blood-donator-by-first-name";
        }
        model.addAttribute("bloodDonatorList", bloodDonatorList);
        return "blood-donators/find-blood-donator-by-first-name";
    }

    @GetMapping("/find-blood-donator-by-city")
    String findByDonatorByCity() {
        return "blood-donators/find-blood-donator-by-city";
    }

    @PostMapping("/find-blood-donator-by-city")
    String findDonatorByCity(Model model, String city) {
        List<BloodDonatorViewModel> bloodDonatorList = this.bloodDonatorService.findByCityStartWith(city);
        model.addAttribute("bloodDonatorList", bloodDonatorList);
        return "blood-donators/find-blood-donator-by-city";
    }

    @PostMapping("/blood-donator-id")
    String getBloodDonatorId(@RequestParam("donatorId") long id, Model model) {
        long donatorId = id;
        model.addAttribute("id", id);

        return "blood-donators/add-blood-donation";
    }

    @PostMapping("/add-blood-donation")
    String addBloodDonation(@RequestParam("donatorId") long id, Model model, String date) throws ParseException {

        if (date == "") {
            model.addAttribute("id", id);
            return "blood-donators/add-blood-donation";
        }

        this.bloodDonatorService.addBloodDonation(id, date);
        BloodDonatorViewModel bloodDonator = this.bloodDonatorService.findBloodDonatorById(id);
        model.addAttribute("bloodDonator", bloodDonator);


        return "blood-donators/blood-donator";
    }

    @GetMapping("/find-blood-donator-by-username")
    public String findDonatorByUsername() {
        return "blood-donators/blood-donator-donations";
    }

    @PostMapping("/find-blood-donator-by-username")
    public String findDonatorByUsername(Model model, String username) {
        if (username == "") {
            return "blood-donators/blood-donator-donations";
        }
        BloodDonatorViewModel bloodDonator = this.bloodDonatorService.findBloodDonatorByUsername(username);

        if (bloodDonator == null) {
            return "blood-donators/blood-donator-donations";
        }
        long bloodDonatorId = bloodDonator.getId();
        List<BloodDonationViewModel> bloodDonations = this.bloodDonationService.findDonationsByBloodDonatorId(bloodDonatorId);
        model.addAttribute("bloodDonator", bloodDonator);
        model.addAttribute("bloodDonations", bloodDonations);

        return "blood-donators/blood-donator-donations";
    }


    @RequestMapping("/blood-donator-info")
    public String getBloodDonatorInfo(HttpServletRequest req, Model model) {
        String username = req.getRemoteUser();
        BloodDonatorViewModel bloodDonator = this.bloodDonatorService.findBloodDonatorByUsername(username);
        if (bloodDonator == null) {
            return "unsuccessfully-completed";
        }
        model.addAttribute("bloodDonator", bloodDonator);

        return "blood-donators/blood-donator-info";
    }

    @GetMapping("/edit-blood-donator")
    String edit() {
        return "blood-donators/edit-blood-donator";
    }


    @PostMapping("/edit-blood-donator")
    String edit(HttpServletRequest req, String firstName, String lastName, String ageString, boolean isActiveBloodDonator, Address address) {
        int age = 0;
        if (ageString != "") {
            age = Integer.parseInt(ageString);
        }
        String username = req.getRemoteUser();
        if (username == null) {
            return "blood-donators/edit-blood-donator";
        }
        BloodDonatorViewModel bloodDonator = this.bloodDonatorService.findBloodDonatorByUsername(username);
        int id = (int) bloodDonator.getId();

        this.bloodDonatorService.editBloodDonatorById(firstName, lastName, age, isActiveBloodDonator, address, id);

        return "successfully-edited";
    }
}



