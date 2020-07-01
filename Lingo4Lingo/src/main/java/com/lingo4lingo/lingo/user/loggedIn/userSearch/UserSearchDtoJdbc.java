package com.lingo4lingo.lingo.user.loggedIn.userSearch;

import com.lingo4lingo.lingo.user.User;
import com.lingo4lingo.lingo.user.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserSearchDtoJdbc {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserSearchDtoJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> getUserByCity(String city) {
        final String sql =
                "SELECT * FROM users WHERE city = ?";
        return jdbcTemplate.query(sql, new Object[]{city}, new UserMapper());
    }

    public List<User> getUserBySpokenLanguage(String spokenLanguage) {
        final String sql =
                "SELECT * FROM users WHERE MATCH " +
                        "(language_native_1," +
                        "language_native_2," +
                        "language_native_3," +
                        "language_spoken_1," +
                        "language_spoken_2," +
                        "language_spoken_3," +
                        "language_spoken_4," +
                        "language_spoken_5) " +
                        "against(\"+\"? in boolean mode)";

        return jdbcTemplate.query(sql, new Object[]{spokenLanguage}, new UserMapper());
    }

    public List<User> getUserByLanguageAndCity(String city, String spokenLanguage) {
        final String sql =
                "SELECT * FROM (" +
                        "SELECT * From users where city=?)as s " +
                        "WHERE MATCH (" +
                        "language_native_1," +
                        "language_native_2," +
                        "language_native_3," +
                        "language_spoken_1," +
                        "language_spoken_2," +
                        "language_spoken_3," +
                        "language_spoken_4," +
                        "language_spoken_5" +
                        ") against(\"+\"? in boolean mode)";

        return jdbcTemplate.query(sql, new Object[]{city, spokenLanguage}, new UserMapper());

    }

    public List<User> getUserByNativeLanguage(String spokenLanguage) {
        final String sql =
                "SELECT * FROM users WHERE MATCH " +
                        "(language_native_1," +
                        "language_native_2," +
                        "language_native_3)" +
                        "against(\"+\"? in boolean mode)";

        return jdbcTemplate.query(sql, new Object[]{spokenLanguage}, new UserMapper());
    }

    public List<User> getUserByNativeLanguageAndCity(String city, String spokenLanguage) {
        final String sql =
                "SELECT * FROM (" +
                        "SELECT * From users where city=?)as s " +
                        "WHERE MATCH (" +
                        "language_native_1," +
                        "language_native_2," +
                        "language_native_3" +
                        ") against(\"+\"? in boolean mode)";

        return jdbcTemplate.query(sql, new Object[]{city, spokenLanguage}, new UserMapper());

    }

}
