package com.lingo4lingo.lingo.model.entity;

import com.lingo4lingo.lingo.model.enums.City;
import com.lingo4lingo.lingo.model.enums.Countries;
import com.lingo4lingo.lingo.model.enums.Gender;
import com.lingo4lingo.lingo.model.enums.Language;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class User {


    /* @GeneratedValue(generator = "UUID")
     @GenericGenerator(
             name = "UUID",
             strategy = "org.hibernate.id.UUIDGenerator",
             parameters = {
                     @Parameter(
                             name = "uuid_gen_strategy_class",
                             value = "org.hibernate,id.uuid.CostumVersionStrategy"
                     )
             }
     )

     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(name = "id")
    private long id;

    //@Column(name = "username")
    @NotEmpty
    private String userName;

    //@Column(name = "email")
    @Email(message = "Please provide a valid e-mail")
    @NotEmpty(message = "Please provide an e-mail")
    private String email;

    //@Column(name = "password")
    @Transient
    private String password;


    //@Column(name = "confirmationToken")
    private String ConfirmationToken;

    //@Column(name = "enabled")
    private boolean enabled;

    private String login;
    private Gender gender;
    private int age;
    private Countries country;
    private City city;
    private String regionProvince;
    //private List<Language> nativeLanguages; %%%%%% zaciagane z bazy danych??
    //private List<Language> practicingLanguages;
    //private List<Language> languagesToLearn;
    //private String selfDescription;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

    public User() {

    }

    public User(long id, String userName, String email, String login, String password, Gender gender, int age, Countries country, City city, List<Language> nativeLanguages, List<Language> practicingLanguages, List<Language> languagesToLearn, String selfDescription) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.login = login;
        this.password = password;
        this.gender = gender;
        this.age = age;
        this.country = country;
        this.city = city;
        //this.nativeLanguages = nativeLanguages;
        //this.practicingLanguages = practicingLanguages;
        //this.languagesToLearn = languagesToLearn;
        //this.selfDescription = selfDescription;
    }
    public User(String confirmationToken) {
        ConfirmationToken = confirmationToken;
    }


    /*
     * Setters

     */


    public void setId(long id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCountry(Countries country) {
        this.country = country;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public void setRegionProvince(String regionProvince) {
        this.regionProvince = regionProvince;
    }

    public void setConfirmationToken(String confirmationToken) {
        ConfirmationToken = confirmationToken;
    }

    /* public void setNativeLanguages(List<Language> nativeLanguages) {
        this.nativeLanguages = nativeLanguages;
    }

    public void setPracticingLanguages(List<Language> practicingLanguages) {
        this.practicingLanguages = practicingLanguages;
    }

    public void setLanguagesToLearn(List<Language> languagesToLearn) {
        this.languagesToLearn = languagesToLearn;
    }

    public void setSelfDescription(String selfDescription) {
        this.selfDescription = selfDescription;
    }

     */



    /*
     * Getters
     */


    public long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public Countries getCountry() {
        return country;
    }

    public City getCity() {
        return city;
    }

    public String getRegionProvince() {
        return regionProvince;
    }

    public String getConfirmationToken() {
        return ConfirmationToken;
    }
/*
     public List<Language> getNativeLanguages() {
        return nativeLanguages;
    }

    public List<Language> getPracticingLanguages() {
        return practicingLanguages;
    }

    public List<Language> getLanguagesToLearn() {
        return languagesToLearn;
    }

    public String getSelfDescription() {
        return selfDescription;
    }


 */


    @Override
    public String toString() {
        return "User{" +
                "UserId=" + id +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", country=" + country +
                ", city=" + city +
                ", regionProvince='" + regionProvince + '\'' +
                // ", nativeLanguages=" + nativeLanguages +
                //", practicingLanguages=" + practicingLanguages +
                //", languagesToLearn=" + languagesToLearn +
                //", selfDescription='" + selfDescription + '\'' +
                '}';
    }


}