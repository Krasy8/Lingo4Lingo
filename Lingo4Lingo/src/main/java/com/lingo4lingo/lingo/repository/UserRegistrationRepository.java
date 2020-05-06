package com.lingo4lingo.lingo.repository;

import com.lingo4lingo.lingo.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class UserRegistrationRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRegistrationRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<String> selectAllCountries() {
        String sql = "" +
                "SELECT " +
                " country_name " +
                "FROM countries";
        return jdbcTemplate.query(sql, countryMapper());
    }

    private RowMapper<String> countryMapper() {
        return ((resultSet, i) -> resultSet.getString("country_name"));
    }

    public List<String> selectCitiesByCountry(String country) {
        String sql = "" +
                "SELECT DISTINCT" +
                " city_name, " +
                " country_name " +
                "FROM  cities_in_countries " +
                "WHERE country_name = ?";
        return jdbcTemplate.query(sql, new Object[] {country}, cityMapper());
    }

    private RowMapper<String> cityMapper() {
        return (((resultSet, i) -> resultSet.getString("city_name")));
    }

    public List<String> selectUniqueLanguages() {
        String sql = "" +
                "SELECT DISTINCT" +
                " official_languages " +
                "FROM countries_languages " +
                "WHERE official_languages IS NOT NULL " +
                "ORDER BY official_languages";
        return jdbcTemplate.query(sql, languageMapper());
    }

    private RowMapper<String> languageMapper() {
        return (((resultSet, i) -> resultSet.getString("official_languages")));
    }

    public int insertUser(User user) {
        String sql = "" +
                "INSERT INTO users (login, password, email, gender, age, country, city, region_province, " +
                "language_native_1, language_native_2, language_native_3, language_spoken_1, language_spoken_2, " +
                "language_spoken_3, language_spoken_4, language_spoken_5, language_to_learn, self_description, " +
                "created_at, updated_at) " +
                "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(
                sql,
                user.getLogin(),
                user.getPassword(),
                user.getEmail(),
                user.getGender().name().toUpperCase(),
                user.getAge(),
                user.getCountry(),
                user.getCity(),
                user.getRegionProvince(),
                user.getLanguageNative1(),
                user.getLanguageNative2(),
                user.getLanguageNative3(),
                user.getLanguageSpoken1(),
                user.getLanguageSpoken2(),
                user.getLanguageSpoken3(),
                user.getLanguageSpoken4(),
                user.getLanguageSpoken5(),
                user.getLanguageToLearn(),
                user.getSelfDescription(),
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }

    public boolean isEmailTaken(String email) {
        String sql = "" +
                "SELECT EXISTS (SELECT 1 FROM users WHERE email = ?)";
        return jdbcTemplate.queryForObject(
                sql,
                new Object[] {email},
                (resultSet, i) -> resultSet.getBoolean(1)
        );
    }
}
