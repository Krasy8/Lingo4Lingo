package com.lingo4lingo.lingo.user.registration;

import com.lingo4lingo.lingo.user.User;
import com.lingo4lingo.lingo.userManagement.UserManagementService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
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
        User newUser = new User(11L, "user1", "password", "user11@gmail.com",
                User.Gender.MALE, new Date(1991, Calendar.DECEMBER, 15), "Poland", "Warsaw",
                "Polish", "English", "German");

        //when
        userRegistrationService.addNewUser(newUser);

        //then

        assertThat(userRegistrationService.isEmailTaken(newUser.getEmail())).isEqualTo(true);

    }

    @Test
    void shouldReturnTrue() {
        boolean actual = userRegistrationService.isEmailTaken("user1@gmail.com");
        assertThat(actual).isEqualTo(true);

    }
}