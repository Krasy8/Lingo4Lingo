ALTER TABLE users
    CHANGE country country_of_residence VARCHAR(45) CHARACTER SET UTF8MB4,
    CHANGE city city_of_residence VARCHAR(45) CHARACTER SET UTF8MB4;
