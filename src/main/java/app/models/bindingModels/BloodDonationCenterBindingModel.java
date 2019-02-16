package app.models.bindingModels;

import app.entities.Address;
import app.models.viewModels.BloodDonatorViewModel;

import java.util.Set;
import java.util.TreeSet;

public class BloodDonationCenterBindingModel {
    private long id;
    private String name;
    private Address address;
    private Set<BloodDonatorViewModel> bloodDonators;

    public BloodDonationCenterBindingModel() {
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
