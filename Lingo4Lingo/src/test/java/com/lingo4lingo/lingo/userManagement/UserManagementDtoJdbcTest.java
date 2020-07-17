package com.lingo4lingo.lingo.userManagement;

import com.lingo4lingo.lingo.user.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class UserManagementDtoJdbcTest {

    private final User user = new User(1L, "user1", "test123", "user1@gmail.com",
            User.Gender.MALE, new Date(1981 - 12 - 15), "Poland", "Warsaw",
            "Polish", "English", "German");

    private final UserManagementDtoJdbc userManagementDtoJdbc;

    @Autowired
    UserManagementDtoJdbcTest(UserManagementDtoJdbc userManagementDtoJdbc) {
        this.userManagementDtoJdbc = userManagementDtoJdbc;
    }

    @Test
    void shouldReturn5with5users() {
        //when
        int actual = userManagementDtoJdbc.selectAllUsers().size();

        //then
        assertThat(actual).isEqualTo(5);
    }

    @Test
    void shouldReturnThisSameEmail() {
        String actual = userManagementDtoJdbc.getUserById(1L).getEmail();

        assertThat(actual).isEqualTo(user.getEmail());

    }

    @Transactional
    @Test
    void shouldReturn4() {
        int actual = userManagementDtoJdbc.selectAllUsers().size() - 1;
        userManagementDtoJdbc.deleteById(1L);

        assertThat(actual).isEqualTo(4);
    }
}