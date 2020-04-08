package com.lingo4lingo.lingo.model.enums;

public enum City {

    LONDON(Countries.UNITED_KINGDOM, "London"),
    MANCHESTER(Countries.UNITED_KINGDOM, "Manchester"),
    BRISTOL(Countries.UNITED_KINGDOM, "Bristol");

    public Countries countries;
    public String cityName;

    City(Countries countries, String cityName) {
        this.countries = countries;
        this.cityName = cityName;
    }


}