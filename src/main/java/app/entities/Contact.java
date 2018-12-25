package app.entities;

import javax.persistence.*;

@Entity
@Table(name="contacts")
public class Contact  implements Comparable<Contact> {
    private long id;
    private String email;
    private String phone;
    private String fax;
    private BloodDonationCenter bloodDonationCenter;
    private BloodDonator bloodDonator;

    public Contact() {
    }
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    @Column(name="email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Column(name="phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    @Column(name="fax")
    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    @ManyToOne(targetEntity = BloodDonationCenter.class,cascade = CascadeType.ALL)
    public BloodDonationCenter getBloodDonationCenter() {
        return bloodDonationCenter;
    }

    public void setBloodDonationCenter(BloodDonationCenter bloodDonationCenter) {
        this.bloodDonationCenter = bloodDonationCenter;
    }
    @ManyToOne(targetEntity = BloodDonator.class,cascade = CascadeType.ALL)
    public BloodDonator getBloodDonator() {
        return bloodDonator;
    }

    public void setBloodDonator(BloodDonator bloodDonator) {
        this.bloodDonator = bloodDonator;
    }

    @Override
    public int compareTo(Contact contact) {
      int result = this.email.compareTo(contact.email);
        return result;
    }
}
