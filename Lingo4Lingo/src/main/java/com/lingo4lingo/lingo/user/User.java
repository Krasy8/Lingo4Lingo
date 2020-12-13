package com.lingo4lingo.lingo.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lingo4lingo.lingo.security.securityModel.Role;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;

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

    private Date dateOfBirth;

    private String countryOfResidence;

    private String cityOfResidence;

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
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    private boolean enabled;

    private boolean tokenExpired;

    @JsonIgnore
    @ManyToMany
    @JoinColumn(name = "users_id")
    private Collection<Role> roles;

    public User(@JsonProperty("id") Long id, @JsonProperty("login") String login,
            @JsonProperty("password") String password,
            @JsonProperty("email") @Email(message = "Please provide a valid e-mail") @NotEmpty(message = "Please provide "
                    + "an e-mail") String email,
            @JsonProperty("gender") Gender gender, @JsonProperty("dateOfBirth") Date dateOfBirth,
            @JsonProperty("countryOfResidence") String countryOfResidence,
            @JsonProperty("cityOfResidence") String cityOfResidence,
            @JsonProperty("languageNative1") String languageNative1,
            @JsonProperty("languageSpoken1") String languageSpoken1,
            @JsonProperty("languageToLearn") String languageToLearn) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.countryOfResidence = countryOfResidence;
        this.cityOfResidence = cityOfResidence;
        this.languageNative1 = languageNative1;
        this.languageSpoken1 = languageSpoken1;
        this.languageToLearn = languageToLearn;
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

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
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

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isTokenExpired() {
        return tokenExpired;
    }

    public void setTokenExpired(boolean tokenExpired) {
        this.tokenExpired = tokenExpired;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", login='" + login + '\'' + ", password='" + password + '\'' + ", email='"
                + email + '\'' + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth + ", countryOfResidence='"
                + countryOfResidence + '\'' + ", cityOfResidence='" + cityOfResidence + '\'' + ", regionProvince='"
                + regionProvince + '\'' + ", languageNative1='" + languageNative1 + '\'' + ", languageNative2='"
                + languageNative2 + '\'' + ", languageNative3='" + languageNative3 + '\'' + ", languageSpoken1='"
                + languageSpoken1 + '\'' + ", languageSpoken2='" + languageSpoken2 + '\'' + ", languageSpoken3='"
                + languageSpoken3 + '\'' + ", languageSpoken4='" + languageSpoken4 + '\'' + ", languageSpoken5='"
                + languageSpoken5 + '\'' + ", languageToLearn='" + languageToLearn + '\'' + ", selfDescription='"
                + selfDescription + '\'' + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", enabled="
                + enabled + ", tokenExpired=" + tokenExpired + ", role=" + roles + '}';
    }

    public enum Gender {
        MALE("Male"), FEMALE("Female"), OTHER("Other");

        Gender(String sex) {
        }
    }
}
