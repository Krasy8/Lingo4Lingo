package com.lingo4lingo.lingo.user.userRegistration;

import com.lingo4lingo.lingo.user.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
class UserRegistrationServiceTest {

    @Autowired
    private UserRegistrationService userRegistrationService;


    @Test
    void shouldReturn233Countries() {
        //when
        int actual = userRegistrationService.getAllCountries().size();
        //then
        assertThat(actual).isEqualTo(223);
    }

    @Test
    void shouldReturn26PolishCities() {
        //when
        int actual = userRegistrationService.getCitiesByCountry("Poland").size();
        //then
        assertThat(actual).isEqualTo(26);
    }

    @Test
    void shouldReturn140UniqeLanguages() {
        //when
        int actual = userRegistrationService.getUniqueLanguages().size();
        //then
        assertThat(actual).isEqualTo(140);
    }

    @Test
    @Transactional
    void addNewUser() {
        //given
        Calendar calendar = Calendar.getInstance();
        calendar.set(1991, 11, 15);
        Date birthDate = calendar.getTime();

        UserRegistrationDto newUser = new UserRegistrationDto();
//        11L, "user1", "password", "user11@gmail.com",
//                User.Gender.MALE, birthDate, "Poland", "Warsaw",
//                "Polish", "English", "German"

        newUser.setLogin("user1");
        newUser.setPassword("password");
        newUser.setEmail("user11@gmail.com");
        newUser.setGender(String.valueOf(User.Gender.MALE));
        newUser.setDateOfBirth(birthDate);
        newUser.setCountryOfResidence("Poland");
        newUser.setCityOfResidence("Warsaw");
        newUser.setLanguageNative1("Polish");
        newUser.setLanguageSpoken1("English");
        newUser.setLanguageToLearn("German");

        //when
        userRegistrationService.registerNewUser(newUser);

        //then

        assertThat(userRegistrationService.isEmailTaken(newUser.getEmail())).isEqualTo(true);

    }

    @Test
    void shouldReturnTrue() {
        boolean actual = userRegistrationService.isEmailTaken("krasy@gmail.com");
        assertThat(actual).isEqualTo(true);

    }
}
