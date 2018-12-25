package app.entities;

import app.entities.enums.BloodGroup;
import app.entities.enums.Sex;

import javax.persistence.*;
import java.util.Set;
import java.util.TreeSet;

@Entity
@Table(name = "blood_donators")
public class BloodDonator {
    private long id;
    private String firstName;
    private String lastName;
    private int age;
    private Sex sex;
    private Address address;
    private boolean isActiveBloodDonator;
    private int numberOfBloodDonation;
    private BloodGroup bloodGroup;
    private boolean isRhPositive;
    private Set<BloodDonation> bloodDonations;
    private BloodDonationCenter bloodDonationCenter;
    private Set<Contact> contacts;
    private User user;

    public BloodDonator() {
        this.contacts = new TreeSet<>();
        this.bloodDonations = new TreeSet<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "age")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "sex")
    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    @OneToOne
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Column(name = "is_active_blood_donator")
    public boolean isActiveBloodDonator() {
        return isActiveBloodDonator;
    }

    public void setActiveBloodDonator(boolean activeBloodDonator) {
        this.isActiveBloodDonator = activeBloodDonator;
    }

    @Column(name = "number_of_blood_donation")
    public int getNumberOfBloodDonation() {
        return numberOfBloodDonation;
    }

    public void setNumberOfBloodDonation(int numberOfBloodDonation) {
        this.numberOfBloodDonation = numberOfBloodDonation;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "blood_group")
    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    @Column(name = "is_rh_positive")
    public boolean isRhPositive() {
        return isRhPositive;
    }

    public void setRhPositive(boolean rhPositive) {
        this.isRhPositive = rhPositive;
    }

    @OneToMany(mappedBy = "bloodDonator")
    public Set<BloodDonation> getBloodDonations() {
        return bloodDonations;
    }

    public void setBloodDonations(Set<BloodDonation> bloodDonations) {
        this.bloodDonations = bloodDonations;
    }

    @ManyToOne(targetEntity = BloodDonationCenter.class, cascade = CascadeType.ALL)
    public BloodDonationCenter getBloodDonationCenter() {
        return bloodDonationCenter;
    }

    public void setBloodDonationCenter(BloodDonationCenter bloodDonationCenter) {
        this.bloodDonationCenter = bloodDonationCenter;
    }

    @OneToMany(mappedBy = "bloodDonator")
    public Set<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
    }

    public void addContact(Contact contact) {
        this.contacts.add(contact);
    }

    public void addDonation(BloodDonation donation) {
        this.bloodDonations.add(donation);
        this.numberOfBloodDonation += 1;
    }

    @OneToOne
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
