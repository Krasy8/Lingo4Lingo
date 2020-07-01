package com.lingo4lingo.lingo.user.loggedIn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;

@Repository
public class UserDtoJdbc {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDtoJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;

    }

    boolean selectExistEmail(Long id, String email) {
        String sql = "" +
                "SELECT EXISTS ( " +
                "   SELECT 1 " +
                "   FROM users" +
                "   WHERE id <> ? " +
                "    AND email = ? " +
                ")";
        return jdbcTemplate.queryForObject(
                sql,
                new Object[]{id, email},
                (resultSet, columnIndex) -> resultSet.getBoolean(1)
        );
    }

    Long updateLogin(Long id, String login) {
        String sql = "" +
                "UPDATE users " +
                "SET login = ?, updated_at = ? " +
                "WHERE id = ?";
        jdbcTemplate.update(sql, login, ZonedDateTime.now().toLocalDateTime(), id);
        return id;
    }

    Long updateEmail(Long id, String email) {
        String sql = "" +
                "UPDATE users " +
                "SET email = ? " +
                "WHERE id = ?";
        jdbcTemplate.update(sql, email, id);
        return id;
    }


    Long updateGender(Long id, String gender) {
        String sql = "" +
                "UPDATE users " +
                "SET gender = ? " +
                "WHERE id = ?";
        jdbcTemplate.update(sql, gender, id);
        return id;
    }

    Long updateCityOfResidence(Long id, String cityOfResidence) {
        String sql = "" +
                "UPDATE users " +
                "SET city_of_residence = ? " +
                "WHERE id = ?";
        jdbcTemplate.update(sql, cityOfResidence, id);
        return id;
    }

    Long updateCountryOfResidence(Long id, String countryOfResidence) {
        String sql = "" +
                "UPDATE users " +
                "SET country_of_residence = ? " +
                "WHERE id = ?";
        jdbcTemplate.update(sql, countryOfResidence, id);
        return id;
    }

    Long updateRegion(Long id, String regionprovince) {
        String sql = "" +
                "UPDATE users " +
                "SET region_province = ? " +
                "WHERE id = ?";
        jdbcTemplate.update(sql, regionprovince, id);
        return id;
    }

    Long updateLanguageNative1(Long id, String languageNative1) {
        String sql = "" +
                "UPDATE users " +
                "SET language_native_1 = ? " +
                "WHERE id = ?";
        jdbcTemplate.update(sql, languageNative1, id);
        return id;
    }
}
