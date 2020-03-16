package com.napier.sem.models;

import java.util.ArrayList;

public class Population extends Model {
    private String name;
    private int population;
    private double inCities, outCities;

    public ArrayList<String> getValues() {
        ArrayList<String> values = new ArrayList<>();

        values.add( name );
        values.add( Integer.toString(population));
        values.add( Double.toString(inCities)+"%");
        values.add( Double.toString(outCities)+"%");

        return values;
    }

    public ArrayList<String> getHeaders() {
        ArrayList<String> headers = new ArrayList<>();

        headers.add ("Name");
        headers.add ("Total Population");
        headers.add ("Population In Cities");
        headers.add ("Population Out of Cities");

        return headers;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public double getInCities() {
        return inCities;
    }

    public void setInCities(double inCities) {
        this.inCities = inCities;
    }

    public double getOutCities() {
        return outCities;
    }

    public void setOutCities(double outCities) {
        this.outCities = outCities;
    }

}
