package app.services;

import app.entities.Address;
import app.entities.BloodDonator;
import app.models.bindingModels.BloodDonatorRegistrationModel;
import app.models.bindingModels.EditBloodDonatorBindingModel;
import app.models.viewModels.BloodDonatorViewModel;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
public interface BloodDonatorService {

    List<BloodDonatorViewModel> findAll();

    BloodDonatorViewModel findBloodDonatorById(long id);

    BloodDonatorViewModel findBloodDonatorByUsername(String name);

    BloodDonator findByLastName();

    BloodDonator findByBloodGroup();

    void save(BloodDonatorRegistrationModel bloodDonatorRegistrationModel, String bloodDonationCenterName);

    List<BloodDonatorViewModel> findByCityStartWith(String city);

    BloodDonator findById(long id);

    void addBloodDonation(long id, String date) throws ParseException;

    void edit(EditBloodDonatorBindingModel editBloodDonatorBindingModel);

    List<BloodDonatorViewModel> findBloodDonator(long id);

    List<BloodDonatorViewModel> findByFirstName(String firstName);

    void editBloodDonatorById(String firstName, String lastName, int age, boolean isActiveBloodDonator, Address address, long id);
}
