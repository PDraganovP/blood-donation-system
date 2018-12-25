package app.services;

import app.entities.Address;
import app.entities.BloodDonationCenter;
import app.entities.User;
import app.models.bindingModels.BloodDonationCenterRegistrationModel;
import app.models.bindingModels.EditBloodDonationCenterBindingModel;
import app.models.bindingModels.EditBloodDonatorBindingModel;
import app.models.viewModels.BloodDonationCenterViewModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BloodDonationCenterService {

    List<BloodDonationCenter> findAll();

    BloodDonationCenter findByCity();

    BloodDonationCenter findById();

    BloodDonationCenter findByName(String name);

    void save(BloodDonationCenterRegistrationModel bloodDonationCenterRegistrationModel);

    BloodDonationCenterViewModel findBloodDonationCenterByUsername(String username);

    void editBloodDonationCenterById(String name, Address address, long id);
}
