package com.lingo4lingo.lingo.model.entity;

import com.lingo4lingo.lingo.model.enums.City;
import com.lingo4lingo.lingo.model.enums.Country;
import com.lingo4lingo.lingo.model.enums.Gender;
import com.lingo4lingo.lingo.model.enums.Language;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.UUID;

@Entity(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)", unique = true)
    private UUID id;

    private String login;

    @Transient
    private String password;

    @Email(message = "Please provide a valid e-mail")
    @NotEmpty(message = "Please provide an e-mail")
    @Column(unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    private int age;

    @Enumerated(EnumType.STRING)
    @Column(name = "country")
    private Country country;

    @Enumerated(EnumType.STRING)
    @Column(name = "city")
    private City city;

    private String regionProvince;

    @Column(name = "language_native_1")
    @Enumerated(EnumType.STRING)
    private Language languageNative1;

    @Column(name = "language_native_2")
    @Enumerated(EnumType.STRING)
    private Language languageNative2;

    @Column(name = "language_native_3")
    @Enumerated(EnumType.STRING)
    private Language languageNative3;

    @Column(name = "language_spoken_1")
    @Enumerated(EnumType.STRING)
    private Language languageSpoken1;

    @Column(name = "language_spoken_2")
    @Enumerated(EnumType.STRING)
    private Language languageSpoken2;

    @Column(name = "language_spoken_3")
    @Enumerated(EnumType.STRING)
    private Language languageSpoken3;

    @Column(name = "language_spoken_4")
    @Enumerated(EnumType.STRING)
    private Language languageSpoken4;

    @Column(name = "language_spoken_5")
    @Enumerated(EnumType.STRING)
    private Language languageSpoken5;

    @Enumerated(EnumType.STRING)
    private Language languageToLearn;

    private String selfDescription;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

    public User() {

    }

    public User(
            UUID id,
            String login,
            String password,
            @Email(message = "Please provide a valid e-mail")
            @NotEmpty(message = "Please provide " + "an e-mail")
                    String email,
            Gender gender,
            int age,
            Country country,
            City city,
            Language languageNative1,
            Language languageSpoken1,
            Language languageToLearn
    ) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.gender = gender;
        this.age = age;
        this.country = country;
        this.city = city;
        this.languageNative1 = languageNative1;
        this.languageSpoken1 = languageSpoken1;
        this.languageToLearn = languageToLearn;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getRegionProvince() {
        return regionProvince;
    }

    public void setRegionProvince(String regionProvince) {
        this.regionProvince = regionProvince;
    }

    public Language getLanguageNative1() {
        return languageNative1;
    }

    public void setLanguageNative1(Language languageNative1) {
        this.languageNative1 = languageNative1;
    }

    public Language getLanguageNative2() {
        return languageNative2;
    }

    public void setLanguageNative2(Language languageNative2) {
        this.languageNative2 = languageNative2;
    }

    public Language getLanguageNative3() {
        return languageNative3;
    }

    public void setLanguageNative3(Language languageNative3) {
        this.languageNative3 = languageNative3;
    }

    public Language getLanguageSpoken1() {
        return languageSpoken1;
    }

    public void setLanguageSpoken1(Language languageSpoken1) {
        this.languageSpoken1 = languageSpoken1;
    }

    public Language getLanguageSpoken2() {
        return languageSpoken2;
    }

    public void setLanguageSpoken2(Language languageSpoken2) {
        this.languageSpoken2 = languageSpoken2;
    }

    public Language getLanguageSpoken3() {
        return languageSpoken3;
    }

    public void setLanguageSpoken3(Language languageSpoken3) {
        this.languageSpoken3 = languageSpoken3;
    }

    public Language getLanguageSpoken4() {
        return languageSpoken4;
    }

    public void setLanguageSpoken4(Language languageSpoken4) {
        this.languageSpoken4 = languageSpoken4;
    }

    public Language getLanguageSpoken5() {
        return languageSpoken5;
    }

    public void setLanguageSpoken5(Language languageSpoken5) {
        this.languageSpoken5 = languageSpoken5;
    }

    public Language getLanguageToLearn() {
        return languageToLearn;
    }

    public void setLanguageToLearn(Language languageToLearn) {
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
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", country=" + country +
                ", city=" + city +
                ", regionProvince='" + regionProvince + '\'' +
                ", languageNative1=" + languageNative1 +
                ", languageNative2=" + languageNative2 +
                ", languageNative3=" + languageNative3 +
                ", languageSpoken1=" + languageSpoken1 +
                ", languageSpoken2=" + languageSpoken2 +
                ", languageSpoken3=" + languageSpoken3 +
                ", languageSpoken4=" + languageSpoken4 +
                ", languageSpoken5=" + languageSpoken5 +
                ", languageToLearn=" + languageToLearn +
                ", selfDescription='" + selfDescription + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
