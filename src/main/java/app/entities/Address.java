package app.entities;

import javax.persistence.*;

@Entity
@Table(name = "addresses")
public class Address {
    private long id;
    private String region;
    private String municipality;
    private String city;
    private String street;
    private BloodDonationCenter bloodDonationCenter;
    private BloodDonator bloodDonator;

    public Address() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    @Column(name = "region")
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }


    @Column(name = "municipality")
    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }


    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    @Column(name = "street")
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @OneToOne()
    public BloodDonationCenter getBloodDonationCenter() {
        return bloodDonationCenter;
    }

    public void setBloodDonationCenter(BloodDonationCenter bloodDonationCenter) {
        this.bloodDonationCenter = bloodDonationCenter;
    }

    @OneToOne
    public BloodDonator getBloodDonator() {
        return bloodDonator;
    }

    public void setBloodDonator(BloodDonator bloodDonator) {
        this.bloodDonator = bloodDonator;
    }
}
