package app.entities;

import javax.persistence.*;
import java.util.Set;
import java.util.TreeSet;

@Entity
@Table(name = "blood_donation_centers")
public class BloodDonationCenter {
    private long id;
    private String name;
    private Address address;
    private String uniqueCodeFromMinistryOfHeath;
    private Set<Contact> contacts;
    private Set<BloodDonator> bloodDonators;
    private User user;

    public BloodDonationCenter() {
        this.bloodDonators = new TreeSet<>();
        this.contacts= new TreeSet<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "unique_code_from_ministry_of_health")
    public String getUniqueCodeFromMinistryOfHeath() {
        return uniqueCodeFromMinistryOfHeath;
    }

    public void setUniqueCodeFromMinistryOfHeath(String uniqueCodeFromMinistryOfHeath) {
        this.uniqueCodeFromMinistryOfHeath = uniqueCodeFromMinistryOfHeath;
    }

    @OneToOne//(targetEntity = Address.class)
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @OneToMany(mappedBy = "bloodDonationCenter")
    public Set<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
    }

    @OneToMany(mappedBy = "bloodDonationCenter")
    public Set<BloodDonator> getBloodDonators() {
        return bloodDonators;
    }

    public void setBloodDonators(Set<BloodDonator> bloodDonators) {
        this.bloodDonators = bloodDonators;
    }

    public void addContact(Contact contact) {
        this.contacts.add(contact);
    }

    public void addBloodDonator(BloodDonator bloodDonator) {
        this.bloodDonators.add(bloodDonator);
    }

    @OneToOne
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
