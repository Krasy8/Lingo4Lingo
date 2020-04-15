package com.lingo4lingo.lingo.model.enums;

public enum City {

    LONDON(Country.UNITED_KINGDOM, "London"),
    MANCHESTER(Country.UNITED_KINGDOM, "Manchester"),
    BRISTOL(Country.UNITED_KINGDOM, "Bristol"),
    NEW_YORK(Country.USA, "New York");

    public Country country;
    public String cityName;

    City(Country country, String cityName) {
        this.country = country;
        this.cityName = cityName;
    }


}
