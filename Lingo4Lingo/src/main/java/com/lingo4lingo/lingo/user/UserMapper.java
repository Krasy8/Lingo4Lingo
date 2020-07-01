package com.lingo4lingo.lingo.user;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getLong("id"));
        user.setLogin(rs.getString("login"));
        user.setPassword(rs.getString("password"));
        user.setEmail(rs.getString("email"));
        user.setGender(User.Gender.valueOf(rs.getString("gender")));
        user.setDateOfBirth(rs.getDate("date_of_birth"));
        user.setCountryOfResidence(rs.getString("country_of_residence"));
        user.setCityOfResidence(rs.getString("city_of_residence"));
        user.setLanguageNative1(rs.getString("language_native_1"));
        user.setLanguageSpoken1(rs.getString("language_spoken_1"));
        user.setRegionProvince(rs.getString("region_province"));
        user.setLanguageNative2(rs.getString("language_native_2"));
        user.setLanguageNative3(rs.getString("language_native_3"));
        user.setLanguageSpoken2(rs.getString("language_spoken_2"));
        user.setLanguageSpoken3(rs.getString("language_spoken_3"));
        user.setLanguageSpoken4(rs.getString("language_spoken_4"));
        user.setLanguageSpoken5(rs.getString("language_spoken_5"));
        user.setSelfDescription(rs.getString("self_description"));
        user.setLanguageToLearn(rs.getString("language_to_learn"));
        return user;
    }
}
