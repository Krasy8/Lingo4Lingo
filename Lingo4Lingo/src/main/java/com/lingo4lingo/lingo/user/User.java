package com.lingo4lingo.lingo.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String login;

    private String password;

    private String email;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private int age;

    private String country;

    private String city;

    private String regionProvince;

    @Column(name = "language_native_1")
    private String languageNative1;

    @Column(name = "language_native_2")
    private String languageNative2;

    @Column(name = "language_native_3")
    private String languageNative3;

    @Column(name = "language_spoken_1")
    private String languageSpoken1;

    @Column(name = "language_spoken_2")
    private String languageSpoken2;

    @Column(name = "language_spoken_3")
    private String languageSpoken3;

    @Column(name = "language_spoken_4")
    private String languageSpoken4;

    @Column(name = "language_spoken_5")
    private String languageSpoken5;

    private String languageToLearn;

    private String selfDescription;

    @CreationTimestamp
    // @NotNull @NotBlank
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public User(
            @JsonProperty("id") Long id,
            @JsonProperty("login") String login,
            @JsonProperty("password") String password,
            @JsonProperty("email") @Email(message = "Please provide a valid e-mail")
            @NotEmpty(message = "Please provide " + "an e-mail")
                    String email,
            @JsonProperty("gender") Gender gender,
            @JsonProperty("age") int age,
            @JsonProperty("country") String country,
            @JsonProperty("city") String city,
            @JsonProperty("languageNative1") String languageNative1,
            @JsonProperty("languageSpoken1") String languageSpoken1,
            @JsonProperty("languageToLearn") String languageToLearn
//            LocalDateTime createdAt, LocalDateTime updatedAt
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
//        this.createdAt = createdAt;
//        this.updatedAt = updatedAt;
    }

    public User() {
    }

    public User(Long id, String login) {

    }

    public User(Long userId, String login, String password, String email, Gender gender) {
        this.gender = gender;
    }

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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
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

    public enum Gender {
        MALE("Male"),
        FEMALE("Female"),
        OTHER("Other");

        Gender(String sex) {
        }
    }
}
