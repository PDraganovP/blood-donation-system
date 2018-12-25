package app.servicesImpl;

import app.entities.BloodDonation;
import app.models.viewModels.BloodDonationViewModel;
import app.repositories.BloodDonationRepository;
import app.services.BloodDonationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BloodDonationServiceImpl implements BloodDonationService {
    @Autowired
    private BloodDonationRepository bloodDonationRepository;
    @Autowired
    private ModelMapper modelMapper;

    public BloodDonationServiceImpl(BloodDonationRepository bloodDonationRepository) {
        this.bloodDonationRepository = bloodDonationRepository;
    }


    @Override
    public List<BloodDonation> findByDonator() {
        return null;
    }

    @Override
    public List<BloodDonation> findByDate() {
        return null;
    }

    @Override
    public List<BloodDonationViewModel> findDonationsByBloodDonatorId(long bloodDonatorId) {
        List<BloodDonation> bloodDonations = this.bloodDonationRepository.findDonationsByBloodDonatorId(bloodDonatorId);
        List<BloodDonationViewModel> bloodDonationViewModels = new ArrayList<>();
        for (BloodDonation bloodDonation : bloodDonations) {
            BloodDonationViewModel bloodDonationViewModel = this.modelMapper.map(bloodDonation, BloodDonationViewModel.class);
            bloodDonationViewModels.add(bloodDonationViewModel);
        }
        return bloodDonationViewModels;
    }
}
