package com.lingo4lingo.lingo.user.userRegistration;

import java.util.Date;

public class UserRegistrationDto {

    private Long id;

    private String login;

    private String password;

    private String email;

    private String gender;

    private Date dateOfBirth;

    private String countryOfResidence;

    private String cityOfResidence;

    private String regionProvince;

    private String languageNative1;

    private String languageNative2;

    private String languageNative3;

    private String languageSpoken1;

    private String languageSpoken2;

    private String languageSpoken3;

    private String languageSpoken4;

    private String languageSpoken5;

    private String languageToLearn;

    private String selfDescription;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCountryOfResidence() {
        return countryOfResidence;
    }

    public void setCountryOfResidence(String countryOfResidence) {
        this.countryOfResidence = countryOfResidence;
    }

    public String getCityOfResidence() {
        return cityOfResidence;
    }

    public void setCityOfResidence(String cityOfResidence) {
        this.cityOfResidence = cityOfResidence;
    }

    public String getRegionProvince() {
        return regionProvince;
    }

    public void setRegionProvince(String regionProvince) {
        this.regionProvince = regionProvince;
    }

    public String getLanguageNative1() {
        return languageNative1;
    }

    public void setLanguageNative1(String languageNative1) {
        this.languageNative1 = languageNative1;
    }

    public String getLanguageNative2() {
        return languageNative2;
    }

    public void setLanguageNative2(String languageNative2) {
        this.languageNative2 = languageNative2;
    }

    public String getLanguageNative3() {
        return languageNative3;
    }

    public void setLanguageNative3(String languageNative3) {
        this.languageNative3 = languageNative3;
    }

    public String getLanguageSpoken1() {
        return languageSpoken1;
    }

    public void setLanguageSpoken1(String languageSpoken1) {
        this.languageSpoken1 = languageSpoken1;
    }

    public String getLanguageSpoken2() {
        return languageSpoken2;
    }

    public void setLanguageSpoken2(String languageSpoken2) {
        this.languageSpoken2 = languageSpoken2;
    }

    public String getLanguageSpoken3() {
        return languageSpoken3;
    }

    public void setLanguageSpoken3(String languageSpoken3) {
        this.languageSpoken3 = languageSpoken3;
    }

    public String getLanguageSpoken4() {
        return languageSpoken4;
    }

    public void setLanguageSpoken4(String languageSpoken4) {
        this.languageSpoken4 = languageSpoken4;
    }

    public String getLanguageSpoken5() {
        return languageSpoken5;
    }

    public void setLanguageSpoken5(String languageSpoken5) {
        this.languageSpoken5 = languageSpoken5;
    }

    public String getLanguageToLearn() {
        return languageToLearn;
    }

    public void setLanguageToLearn(String languageToLearn) {
        this.languageToLearn = languageToLearn;
    }

    public String getSelfDescription() {
        return selfDescription;
    }

    public void setSelfDescription(String selfDescription) {
        this.selfDescription = selfDescription;
    }

    @Override
    public String toString() {
        return "UserRegistrationDto{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", countryOfResidence='" + countryOfResidence + '\'' +
                ", cityOfResidence='" + cityOfResidence + '\'' +
                ", regionProvince='" + regionProvince + '\'' +
                ", languageNative1='" + languageNative1 + '\'' +
                ", languageNative2='" + languageNative2 + '\'' +
                ", languageNative3='" + languageNative3 + '\'' +
                ", languageSpoken1='" + languageSpoken1 + '\'' +
                ", languageSpoken2='" + languageSpoken2 + '\'' +
                ", languageSpoken3='" + languageSpoken3 + '\'' +
                ", languageSpoken4='" + languageSpoken4 + '\'' +
                ", languageSpoken5='" + languageSpoken5 + '\'' +
                ", languageToLearn='" + languageToLearn + '\'' +
                ", selfDescription='" + selfDescription + '\'' +
                '}';
    }
}
