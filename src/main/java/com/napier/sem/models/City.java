package com.napier.sem.models;

import java.util.ArrayList;

public class City extends Model{
    private int id, population;
    private String name, countryCode, district;

    public ArrayList<String> getValues() {
        ArrayList<String> values = new ArrayList<>();

        values.add( Integer.toString( id ) );
        values.add( name );
        values.add( countryCode );
        values.add( district );
        values.add( Integer.toString( population ) );

        return values;
    }

    public ArrayList<String> getHeaders() {
        ArrayList<String> headers = new ArrayList<>();

        headers.add( "Id" );
        headers.add( "Name" );
        headers.add( "Country Code" );
        headers.add( "District" );
        headers.add( "Population" );

        return headers;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
}
