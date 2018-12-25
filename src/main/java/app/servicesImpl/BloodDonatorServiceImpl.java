package app.servicesImpl;

import app.entities.*;
import app.models.bindingModels.BloodDonatorRegistrationModel;
import app.models.bindingModels.EditBloodDonatorBindingModel;
import app.models.viewModels.BloodDonatorViewModel;
import app.repositories.*;
import app.services.BloodDonatorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class BloodDonatorServiceImpl implements BloodDonatorService {
    @Autowired
    private BloodDonatorRepository bloodDonatorRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private BloodDonationRepository bloodDonationRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BloodDonationCenterRepository bloodDonationCenterRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private static final String ROLE = "USER";


    @Autowired
    public BloodDonatorServiceImpl(BloodDonatorRepository bloodDonatorRepository, AddressRepository addressRepository, ContactRepository contactRepository, ModelMapper modelMapper, ModelMapper modelMapper1, BloodDonationRepository bloodDonationRepository, UserRepository userRepository, BloodDonationCenterRepository bloodDonationCenterRepository) {
        this.bloodDonatorRepository = bloodDonatorRepository;
        this.addressRepository = addressRepository;
        this.contactRepository = contactRepository;
        this.modelMapper = modelMapper;
        this.bloodDonationRepository = bloodDonationRepository;
        this.userRepository = userRepository;
        this.bloodDonationCenterRepository = bloodDonationCenterRepository;
    }

    @Override
    public List<BloodDonatorViewModel> findAll() {
        List<BloodDonatorViewModel> donatorViewModels = new ArrayList<>();
        List<BloodDonator> bloodDonators = (List<BloodDonator>) this.bloodDonatorRepository.findAll();
        for (BloodDonator donator : bloodDonators) {
            BloodDonatorViewModel bloodDonatorViewModel = this.modelMapper.map(donator, BloodDonatorViewModel.class);
            String city = donator.getAddress().getCity();
            bloodDonatorViewModel.setCity(city);
            donatorViewModels.add(bloodDonatorViewModel);
        }
        return donatorViewModels;
    }

    @Override
    public BloodDonatorViewModel findBloodDonatorById(long id) {
        BloodDonator bloodDonator = this.bloodDonatorRepository.findById(id);
        BloodDonatorViewModel bloodDonatorViewModel = this.modelMapper.map(bloodDonator, BloodDonatorViewModel.class);
        String city = bloodDonator.getAddress().getCity();
        bloodDonatorViewModel.setCity(city);


        return bloodDonatorViewModel;
    }

    @Override
    public BloodDonatorViewModel findBloodDonatorByUsername(String username) {
        //BloodDonatorViewModel bloodDOnatorViewMOdel=new BloodDonatorViewModel();
        BloodDonator bloodDonator = this.bloodDonatorRepository.findByUsername(username);
        if (bloodDonator == null) {
            return null;
        }
        BloodDonatorViewModel bloodDonatorViewModel = this.modelMapper.map(bloodDonator, BloodDonatorViewModel.class);
        String city = bloodDonator.getAddress().getCity();
        bloodDonatorViewModel.setCity(city);

        return bloodDonatorViewModel;
    }

    @Override
    public List<BloodDonatorViewModel> findByFirstName(String firstName) {
        List<BloodDonatorViewModel> bloodDonatorViewModels = new ArrayList<>();
        List<BloodDonator> bloodDonator = this.bloodDonatorRepository.findByFirstName(firstName);
        for (BloodDonator donator : bloodDonator) {
            if (donator.isActiveBloodDonator()) {
                BloodDonatorViewModel donatorViewModel = modelMapper.map(donator, BloodDonatorViewModel.class);

                String firstNameViewModel = donator.getAddress().getCity();
                donatorViewModel.setCity(firstNameViewModel);
                bloodDonatorViewModels.add(donatorViewModel);
            }
        }
        return bloodDonatorViewModels;
    }

    @Override
    public BloodDonator findByLastName() {
        return null;
    }

    @Override
    public BloodDonator findByBloodGroup() {
        return null;
    }

    @Override
    public void save(BloodDonatorRegistrationModel bloodDonatorRegistrationModel, String bloodDonationCenterName) {

        BloodDonator bloodDonator = this.modelMapper.map(bloodDonatorRegistrationModel, BloodDonator.class);
        this.bloodDonatorRepository.save(bloodDonator);

        BloodDonationCenter donationCenter = this.bloodDonationCenterRepository.findByName(bloodDonationCenterName);
        donationCenter.addBloodDonator(bloodDonator);
        bloodDonator.setBloodDonationCenter(donationCenter);

        Address address = this.modelMapper.map(bloodDonatorRegistrationModel, Address.class);
        bloodDonator.setAddress(address);
        address.setBloodDonator(bloodDonator);
        this.addressRepository.save(address);

        User user = this.modelMapper.map(bloodDonatorRegistrationModel, User.class);
        String encodedPassword = this.bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        bloodDonator.setUser(user);
        user.setBloodDonator(bloodDonator);
        this.userRepository.save(user);

        Role role = this.roleRepository.findByRole(ROLE);
        userRepository.setRole(role, user.getId());

        Contact contact = this.modelMapper.map(bloodDonatorRegistrationModel, Contact.class);
        bloodDonator.addContact(contact);
        contact.setBloodDonator(bloodDonator);
        this.contactRepository.save(contact);
    }

    @Override
    public List<BloodDonatorViewModel> findByCityStartWith(String city) {
        List<BloodDonatorViewModel> bloodDonatorViewModels = new ArrayList<>();
        List<BloodDonator> bloodDonator = this.bloodDonatorRepository.findByCityStartWith(city);
        for (BloodDonator donator : bloodDonator) {
            if (donator.isActiveBloodDonator()) {
                BloodDonatorViewModel donatorViewModel = modelMapper.map(donator, BloodDonatorViewModel.class);

                String cityViewModel = donator.getAddress().getCity();
                donatorViewModel.setCity(cityViewModel);
                bloodDonatorViewModels.add(donatorViewModel);
            }
        }
        return bloodDonatorViewModels;
    }

    @Override
    public BloodDonator findById(long id) {
        BloodDonator bloodDonator = this.bloodDonatorRepository.findById(id);
        return bloodDonator;
    }

    @Override
    public void addBloodDonation(long id, String date) throws ParseException {
        long donatorId = id;
        String date1 = date;
        String modifying = date1.replaceAll("-", "/");
        BloodDonator bloodDonator = this.bloodDonatorRepository.findById(donatorId);
        DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date bloodDonationDate = sdf.parse(modifying);

        BloodDonation bloodDonation = new BloodDonation();
        bloodDonation.setBloodDonationDate(bloodDonationDate);
        bloodDonator.addDonation(bloodDonation);
        // Calendar calendar=sdf.;
        bloodDonation.setBloodDonator(bloodDonator);
        this.bloodDonationRepository.save(bloodDonation);
    }

    @Override
    public void edit(EditBloodDonatorBindingModel editBloodDonatorBindingModel) {

    }

    @Override
    public List<BloodDonatorViewModel> findBloodDonator(long id) {
        List<BloodDonatorViewModel> bloodDonatorList = new ArrayList<>();

        BloodDonator bloodDonator = this.bloodDonatorRepository.findById(id);
        BloodDonatorViewModel bloodDonatorViewModel = this.modelMapper.map(bloodDonator, BloodDonatorViewModel.class);
        String city = bloodDonator.getAddress().getCity();
        bloodDonatorViewModel.setCity(city);
        bloodDonatorList.add(bloodDonatorViewModel);
        return bloodDonatorList;
    }

    @Override
    public void editBloodDonatorById(String firstName, String lastName, int age, boolean isActiveBloodDonator, Address address, long id) {
        BloodDonator bloodDonator = this.bloodDonatorRepository.findById(id);
        String newFirstName = bloodDonator.getFirstName();
        if (firstName != "") {
            newFirstName = firstName;
        }
        String newLastName = bloodDonator.getLastName();
        if (lastName != "") {
            newLastName = lastName;
        }
        int newAge = bloodDonator.getAge();
        if (age != 0) {
            newAge = age;
        }

        boolean isActiveBloodDonatorNew = bloodDonator.isActiveBloodDonator();
        isActiveBloodDonatorNew = isActiveBloodDonator;

        Address newAddress = bloodDonator.getAddress();
        String region = address.getRegion();
        if ((region != "") && (!region.equals("selected"))) {
            newAddress.setRegion(region);
        }
        String municipality = address.getMunicipality();
        if (municipality != "") {
            newAddress.setMunicipality(municipality);
        }
        String city = address.getCity();
        if (city != "") {
            newAddress.setCity(city);
        }
        String street = address.getStreet();
        if (street != "") {
            newAddress.setStreet(street);
        }
        this.bloodDonatorRepository.editBloodDonatorById(newFirstName, newLastName, newAge, isActiveBloodDonatorNew, newAddress, id);
    }

}
