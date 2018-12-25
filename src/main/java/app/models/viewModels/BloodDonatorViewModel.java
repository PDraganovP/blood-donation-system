package app.models.viewModels;


import app.entities.Address;
import app.entities.enums.BloodGroup;

import java.util.Set;
import java.util.TreeSet;

public class BloodDonatorViewModel {
    private long id;
    private String firstName;
    private String lastName;
    private String city;
    private boolean isActiveBloodDonator;
    private int numberOfBloodDonation;
    private BloodGroup bloodGroup;
    private boolean isRhPositive;
    private Set<BloodDonationViewModel> bloodDonations;
    private Address address;

    public BloodDonatorViewModel() {
        this.bloodDonations=new TreeSet<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean isActiveBloodDonator() {
        return isActiveBloodDonator;
    }

    public void setActiveBloodDonator(boolean activeBloodDonator) {
        isActiveBloodDonator = activeBloodDonator;
    }

    public int getNumberOfBloodDonation() {
        return numberOfBloodDonation;
    }

    public void setNumberOfBloodDonation(int numberOfBloodDonation) {
        this.numberOfBloodDonation = numberOfBloodDonation;
    }

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public boolean isRhPositive() {
        return isRhPositive;
    }

    public void setRhPositive(boolean rhPositive) {
        isRhPositive = rhPositive;
    }

    public Set<BloodDonationViewModel> getBloodDonations() {
        return bloodDonations;
    }

    public void setBloodDonations(Set<BloodDonationViewModel> bloodDonations) {
        this.bloodDonations = bloodDonations;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
