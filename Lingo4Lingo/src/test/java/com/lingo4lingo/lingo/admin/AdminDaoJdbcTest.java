package com.lingo4lingo.lingo.admin;

import com.lingo4lingo.lingo.user.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class AdminDaoJdbcTest {

    private final User user = new User(1L, "user1", "test123", "user1@gmail.com",
            User.Gender.MALE, new Date(1981 - 12 - 15), "Poland", "Warsaw",
            "Polish", "English", "German");

    private final AdminDaoJdbc adminDaoJdbc;

    @Autowired
    AdminDaoJdbcTest(AdminDaoJdbc adminDaoJdbc) {
        this.adminDaoJdbc = adminDaoJdbc;
    }

    @Test
    void shouldReturn5with5users() {
        //when
        int actual = adminDaoJdbc.selectAllUsers().size();

        //then
        assertThat(actual).isEqualTo(5);
    }

    @Test
    void shouldReturnThisSameEmail() {
        String actual = adminDaoJdbc.getUserById(1L).getEmail();

        assertThat(actual).isEqualTo(user.getEmail());

    }

    @Transactional
    @Test
    void shouldReturn4() {
        int actual = adminDaoJdbc.selectAllUsers().size() - 1;
        adminDaoJdbc.deleteById(1L);

        assertThat(actual).isEqualTo(4);
    }
}
