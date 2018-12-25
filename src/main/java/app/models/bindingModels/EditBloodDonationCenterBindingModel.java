package app.models.bindingModels;

import javax.validation.constraints.Size;

public class EditBloodDonationCenterBindingModel {

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


    public EditBloodDonationCenterBindingModel() {
    }


    @Size(min = 2, max = 40, message = "Името трябва да е между 2 и 50 символа")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Size(min = 2, max = 50, message = "Потребителското име трябва да е между 2 и 50 символа")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUniqueCodeFromMinistryOfHeath() {
        return uniqueCodeFromMinistryOfHeath;
    }

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


    @Size(min = 1, max = 35, message = "Полето трябва да се попълни")
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