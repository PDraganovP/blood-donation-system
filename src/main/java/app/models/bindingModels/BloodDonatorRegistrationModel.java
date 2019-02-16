package app.models.bindingModels;

import app.entities.enums.BloodGroup;
import app.entities.enums.Sex;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class BloodDonatorRegistrationModel {

    private String username;
    private String firstName;
    private String lastName;
    private int age;
    private Sex sex;
    private boolean isActiveBloodDonator;
    private BloodGroup bloodGroup;
    private boolean isRhPositive;
    private String email;
    private String phone;
    private String fax;
    private String password;
    private String region;
    private String municipality;
    private String city;
    private String street;


    public BloodDonatorRegistrationModel() {
    }

    @Size(min = 5, max = 50, message = "Потребителското име трябва да е между 5 и 50 символа")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Size(min = 2, max = 30, message = "Името трябва да е между 2 и 30 символа")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Size(min = 2, max = 30, message = "Фамилията трябва да е между 2 и 30 символа")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @DecimalMin(value = "18", message = "Трябва да сте над 18 години")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @NotNull(message = "Полето е задължително за попълване!")
    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }


    public boolean isActiveBloodDonator() {
        return isActiveBloodDonator;
    }

    public void setActiveBloodDonator(boolean activeBloodDonator) {
        isActiveBloodDonator = activeBloodDonator;
    }

    @NotNull(message = "Полето е задължително за попълване!")
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

    @Size(min = 5, max = 40, message = "Имейла трябва да е между 5 и 40 символа")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Size(min = 5, max = 15, message = "Телефона трябва да е между 5 и 15 символа")
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

    @Size(min = 5, max = 25, message = "Паролата трябва да е между 5 и 25 символа")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @NotNull(message = "Полето е задължително за попълване!")
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Size(min = 3, max = 40, message = "Общината трябва да е между 3 и 40 символа")
    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    @Size(min = 3, max = 40, message = "Града трябва да е между 3 и 40 символа")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Size(min = 3, max = 40, message = "Улицата трябва да е между 3 и 40 символа")
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
