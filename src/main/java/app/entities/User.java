package app.entities;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    private long id;
    private String username;
    private String password;
    private BloodDonator bloodDonator;
    private BloodDonationCenter bloodDonationCenter;
    private Role role;


    public User() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @OneToOne
    public BloodDonator getBloodDonator() {
        return bloodDonator;
    }

    public void setBloodDonator(BloodDonator bloodDonator) {
        this.bloodDonator = bloodDonator;
    }

    @OneToOne
    public BloodDonationCenter getBloodDonationCenter() {
        return bloodDonationCenter;
    }

    public void setBloodDonationCenter(BloodDonationCenter bloodDonationCenter) {
        this.bloodDonationCenter = bloodDonationCenter;
    }

    @ManyToOne(targetEntity = Role.class, cascade = CascadeType.ALL)
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
