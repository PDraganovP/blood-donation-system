package app.services;

import app.entities.BloodDonation;
import app.models.viewModels.BloodDonationViewModel;

import java.util.List;

public interface BloodDonationService {

    List<BloodDonation> findByDonator();

    List<BloodDonation> findByDate();

    List<BloodDonationViewModel> findDonationsByBloodDonatorId(long bloodDonatorId);
}
