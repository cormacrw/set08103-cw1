package com.napier.sem.models;

import java.util.ArrayList;

public class Country extends Model {
    private String code, name, continent, region, capital;
    private int population;


    public ArrayList<String> getValues() {
        ArrayList<String> values = new ArrayList<>();

        values.add( code );
        values.add( name );
        values.add( continent );
        values.add( region );
        values.add( capital );
        values.add( Integer.toString( population ) );

        return values;
    }

    public ArrayList<String> getHeaders() {
        ArrayList<String> headers = new ArrayList<>();

        headers.add( "Code" );
        headers.add( "Name" );
        headers.add( "Continent" );
        headers.add( "Region" );
        headers.add( "Capital" );
        headers.add( "Population" );

        return headers;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}
