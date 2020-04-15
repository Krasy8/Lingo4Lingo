package com.lingo4lingo.lingo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

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
                "SELECT " +
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
}
