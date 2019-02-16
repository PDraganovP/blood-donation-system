package app.models.viewModels;

import javax.validation.constraints.Size;

public class BloodDonationCenterViewModel {

    private String name;
    private String username;
    private String uniqueCodeFromMinistryOfHeath;
    private String password;
    private String region;
    private String municipality;
    private String city;
    private String street;
    private String email;
    private String phone;
    private String fax;


    public BloodDonationCenterViewModel() {
    }


    @Size(min = 5, max = 50, message = "Името трябва да е между 5 и 50 символа")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Size(min = 5, max = 50, message = "Потребителското име трябва да е между 5 и 50 символа")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUniqueCodeFromMinistryOfHeath() {
        return uniqueCodeFromMinistryOfHeath;
    }

    @Size(min = 10, max = 15, message = "Кода от Министерството на Здравеопазването трябва да е между 10 и 15 символа")
    public void setUniqueCodeFromMinistryOfHeath(String uniqueCodeFromMinistryOfHeath) {
        this.uniqueCodeFromMinistryOfHeath = uniqueCodeFromMinistryOfHeath;
    }

    @Size(min = 5, max = 25, message = "Паролата трябва да е между 5 и 25 символа")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Size(min = 5, max = 35, message = "Полето трябва да се попълни")
    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    @Size(min = 1, max = 35, message = "Полето трябва да се попълни")
    public String getCity() {
        return city;
    }


    public void setCity(String city) {
        this.city = city;
    }

    @Size(min = 5, max = 15, message = "Полето е трябва да се попълни")
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }


    @Size(min = 5, max = 40, message = "Имейла трябва да е между 5 и 40 символа")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Size(min = 5, max = 15, message = "Полето трябва да се попълни")
    public String getPhone() {
        return phone;
    }

    @Size(min = 5, max = 15, message = "Телефона трябва да е между 5 и 15 символа")
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }
}
