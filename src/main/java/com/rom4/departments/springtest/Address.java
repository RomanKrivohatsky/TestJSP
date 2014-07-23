package com.rom4.departments.springtest;

import java.util.Collection;

/**
 * Created by rom4 on 23.07.14.
 * Creation time 17:09
 * Project name Departments
 */
public class Address {

    private City city;
    private Collection<City> bigCities;

    public Collection<City> getBigCities() {
        return bigCities;
    }

    public void setBigCities(Collection<City> bigCities) {
        this.bigCities = bigCities;
    }



    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
