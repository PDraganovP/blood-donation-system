package app.servicesImpl;

import app.entities.*;
import app.models.bindingModels.BloodDonationCenterRegistrationModel;
import app.models.bindingModels.BloodDonationCenterBindingModel;
import app.repositories.*;
import app.services.BloodDonationCenterService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BloodDonationCenterServiceImpl implements BloodDonationCenterService {
    @Autowired
    private BloodDonationCenterRepository bloodDonationCenterRepository;
    @Autowired
    private BloodDonatorRepository bloodDonatorRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private ModelMapper modelMapper;
    private static final String ROLE = "USER";

    @Autowired
    public BloodDonationCenterServiceImpl(BloodDonationCenterRepository bloodDonationCenterRepository, BloodDonatorRepository bloodDonatorRepository, AddressRepository addressRepository, ContactRepository contactRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.bloodDonationCenterRepository = bloodDonationCenterRepository;
        this.bloodDonatorRepository = bloodDonatorRepository;
        this.addressRepository = addressRepository;
        this.contactRepository = contactRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<BloodDonationCenter> findAll() {
        List<BloodDonationCenter> bloodDonationCenters = this.bloodDonationCenterRepository.findAll();
        return bloodDonationCenters;
    }

    @Override
    public BloodDonationCenter findByCity() {
        return null;
    }

    @Override
    public BloodDonationCenter findById() {
        return null;
    }

    @Override
    public BloodDonationCenter findByName(String name) {
        this.bloodDonationCenterRepository.findByName(name);
        return null;
    }

    @Override
    public void save(BloodDonationCenterRegistrationModel bloodDonationCenterRegistrationModel) {
        BloodDonationCenter bloodDonationCenter = this.modelMapper.map(bloodDonationCenterRegistrationModel, BloodDonationCenter.class);
        this.bloodDonationCenterRepository.save(bloodDonationCenter);
        Address address = this.modelMapper.map(bloodDonationCenterRegistrationModel, Address.class);

        bloodDonationCenter.setAddress(address);

        address.setBloodDonationCenter(bloodDonationCenter);
        this.addressRepository.save(address);

        User user = this.modelMapper.map(bloodDonationCenterRegistrationModel, User.class);
        String encodedPassword = this.bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        bloodDonationCenter.setUser(user);
        user.setBloodDonationCenter(bloodDonationCenter);
        this.userRepository.save(user);

        Role userRole = this.roleRepository.findByRole(ROLE);
        userRepository.setRole(userRole, user.getId());

        Contact contact = this.modelMapper.map(bloodDonationCenterRegistrationModel, Contact.class);

        bloodDonationCenter.addContact(contact);
        contact.setBloodDonationCenter(bloodDonationCenter);

        this.contactRepository.save(contact);

    }

    @Override
    public BloodDonationCenterBindingModel findBloodDonationCenterByUsername(String username) {
        BloodDonationCenter bloodDonationCenter = this.bloodDonationCenterRepository.findByUsername(username);
        if (bloodDonationCenter == null) {
            return null;
        }
        BloodDonationCenterBindingModel bloodDonationCenterBindingModel = this.modelMapper.map(bloodDonationCenter, BloodDonationCenterBindingModel.class);

        return bloodDonationCenterBindingModel;
    }

    @Override
    public void editBloodDonationCenterById(String name, Address address, long id) {
        BloodDonationCenter bloodDonationCenter = this.bloodDonationCenterRepository.findById(id);
        Address newAddress = bloodDonationCenter.getAddress();
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
        String centerName = bloodDonationCenter.getName();
        if (name != "") {
            centerName = name;
        }

        this.bloodDonationCenterRepository.editBloodDonationCenterById(centerName, newAddress, id);
    }
}
