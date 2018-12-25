package app.models.viewModels;

import app.entities.Address;

import java.util.Set;
import java.util.TreeSet;

public class BloodDonationCenterViewModel {
    private long id;
    private String name;
    private Address address;
    private Set<BloodDonatorViewModel> bloodDonators;

    public BloodDonationCenterViewModel() {
        bloodDonators = new TreeSet<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address addressViewModel) {
        this.address = addressViewModel;
    }

    public Set<BloodDonatorViewModel> getBloodDonators() {
        return bloodDonators;
    }

    public void setBloodDonators(Set<BloodDonatorViewModel> bloodDonators) {
        this.bloodDonators = bloodDonators;
    }
}
