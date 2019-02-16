package app.services;

import app.entities.Address;
import app.entities.BloodDonationCenter;
import app.models.bindingModels.BloodDonationCenterRegistrationModel;
import app.models.bindingModels.BloodDonationCenterBindingModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BloodDonationCenterService {

    List<BloodDonationCenter> findAll();

    BloodDonationCenter findByCity();

    BloodDonationCenter findById();

    BloodDonationCenter findByName(String name);

    void save(BloodDonationCenterRegistrationModel bloodDonationCenterRegistrationModel);

    BloodDonationCenterBindingModel findBloodDonationCenterByUsername(String username);

    void editBloodDonationCenterById(String name, Address address, long id);
}
