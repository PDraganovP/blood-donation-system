package app.controllers;


import app.entities.Address;
import app.models.bindingModels.BloodDonationCenterRegistrationModel;
import app.models.bindingModels.BloodDonationCenterBindingModel;
import app.models.viewModels.BloodDonatorViewModel;

import app.services.BloodDonationCenterService;
import app.services.BloodDonatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@Controller
public class BloodDonationCenterController {
    @Autowired
    private BloodDonatorService bloodDonatorService;
    @Autowired
    private BloodDonationCenterService bloodDonationCenterService;

    @GetMapping("/blood-donation-center-register")
    public String registrationBloodDonationCenter(@ModelAttribute BloodDonationCenterRegistrationModel bloodDonationCenterRegistrationModel) {
        return "blood-donation-centers/blood-donation-center-register";
    }

    @PostMapping("/blood-donation-center-register")
    public String registrationBloodDonationCenter(@Valid @ModelAttribute BloodDonationCenterRegistrationModel bloodDonationCenterRegistrationModel, BindingResult result, Model model) {
        List<FieldError> fieldErrors = result.getFieldErrors();
        if (result.hasErrors()) {
            for (FieldError err : fieldErrors) {
                String field = err.getField();
                String error = err.getDefaultMessage().toString();
                String param = field + "Error";
                model.addAttribute(param, error);
            }
            return "blood-donation-centers/blood-donation-center-register";
        }

        this.bloodDonationCenterService.save(bloodDonationCenterRegistrationModel);
        return "redirect:/successfully-edited";
    }

    @GetMapping("/find-blood-donation-center-by-username")
    public String findByUsername() {
        return "blood-donation-centers/blood-donation-center";
    }

    @PostMapping("/find-blood-donation-center-by-username")
    public String findByUsername(Model model, String username) {
        BloodDonationCenterBindingModel bloodDonationCenter = this.bloodDonationCenterService.findBloodDonationCenterByUsername(username);
        if (username == "" || bloodDonationCenter == null) {
            return "blood-donation-centers/blood-donation-center";
        }
        Set<BloodDonatorViewModel> bloodDonators = bloodDonationCenter.getBloodDonators();
        model.addAttribute("bloodDonationCenter", bloodDonationCenter);
        model.addAttribute("bloodDonators", bloodDonators);

        return "blood-donation-centers/blood-donation-center";
    }

    @RequestMapping("/blood-donation-center-info")
    public String getBloodDonatorInfo(HttpServletRequest req, Model model) {
        String username = req.getRemoteUser();
        BloodDonationCenterBindingModel bloodDonationCenter = this.bloodDonationCenterService.findBloodDonationCenterByUsername(username);
        model.addAttribute("bloodDonationCenter",bloodDonationCenter);

        return "blood-donation-centers/blood-donation-center-info";
    }

    @GetMapping("/edit-blood-donation-center")
    String edit() {
        return "blood-donation-centers/edit-blood-donation-center";
    }

    @PostMapping("/edit-blood-donation-center")
    String edit(String name , Address address, Model model,HttpServletRequest req) {
        String user = req.getRemoteUser();
        if(user==null){
            return "blood-donation-centers/edit-blood-donation-center";
        }
        BloodDonationCenterBindingModel bloodDonationCenter = this.bloodDonationCenterService.findBloodDonationCenterByUsername(user);
        long id = bloodDonationCenter.getId();
        this.bloodDonationCenterService.editBloodDonationCenterById(name,address,id);

        return "successfully-edited";
    }
}
