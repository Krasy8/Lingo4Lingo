package com.lingo4lingo.lingo.userManagement;

import com.lingo4lingo.lingo.user.User;
import com.lingo4lingo.lingo.user.UserMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserManagementDtoJdbc {

    private final JdbcTemplate jdbcTemplate;

    public UserManagementDtoJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> selectAllUsers() {
        final String sql = "" +
                " SELECT " +
                " id, " +
                " login, " +
                " password, " +
                " email, " +
                " gender, " +
                " age, " +
                " country, " +
                " city, " +
                " region_province, " +
                " language_native_1, " +
                " language_native_2, " +
                " language_native_3, " +
                " language_spoken_1, " +
                " language_spoken_2, " +
                " language_spoken_3, " +
                " language_spoken_4, " +
                " language_spoken_5, " +
                " language_to_learn, " +
                " self_description, " +
                " created_at DATETIME, " +
                " updated_at DATETIME " +
                " FROM users ";
        return jdbcTemplate.query(sql, new UserMapper());
    }

    public User getUserById(Long id) {
        final String sql = "" +
                " SELECT " +
                " id, " +
                " login, " +
                " password, " +
                " email, " +
                " gender, " +
                " age, " +
                " country, " +
                " city, " +
                " region_province, " +
                " language_native_1, " +
                " language_native_2, " +
                " language_native_3, " +
                " language_spoken_1, " +
                " language_spoken_2, " +
                " language_spoken_3, " +
                " language_spoken_4, " +
                " language_spoken_5, " +
                " language_to_learn, " +
                " self_description, " +
                " created_at DATETIME, " +
                " updated_at DATETIME " +
                " FROM users WHERE id = ? ";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new UserMapper());
    }

    public void deleteById(Long id) {
        final String sql =
                "DELETE FROM users " +
                        "WHERE id = ? ";
        jdbcTemplate.update(sql, id);
    }
}
