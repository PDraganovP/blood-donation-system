package app.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "blood_donations")
public class BloodDonation {
    private long id;
    private Date bloodDonationDate;
    private BloodDonator bloodDonator;

    public BloodDonation() {
    }
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    @Column(name = "blood_donation_date")
    public Date getBloodDonationDate() {
        return bloodDonationDate;
    }

    public void setBloodDonationDate(Date bloodDonationDate) {
        this.bloodDonationDate = bloodDonationDate;
    }
    @ManyToOne(targetEntity = BloodDonator.class)
    public BloodDonator getBloodDonator() {
        return bloodDonator;
    }

    public void setBloodDonator(BloodDonator bloodDonator) {
        this.bloodDonator = bloodDonator;
    }
}
