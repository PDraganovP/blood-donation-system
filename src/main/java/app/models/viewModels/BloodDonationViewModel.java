package app.models.viewModels;

import java.util.Date;

public class BloodDonationViewModel {
    private long id;
    private Date bloodDonationDate;
    private BloodDonatorViewModel bloodDonator;

    public BloodDonationViewModel() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getBloodDonationDate() {
        return bloodDonationDate;
    }

    public void setBloodDonationDate(Date bloodDonationDate) {
        this.bloodDonationDate = bloodDonationDate;
    }

    public BloodDonatorViewModel getBloodDonator() {
        return bloodDonator;
    }

    public void setBloodDonator(BloodDonatorViewModel bloodDonator) {
        this.bloodDonator = bloodDonator;
    }
}
