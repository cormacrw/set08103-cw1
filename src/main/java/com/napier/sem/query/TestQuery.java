package com.napier.sem.query;

import com.napier.sem.models.City;
import com.napier.sem.models.Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TestQuery {
    public static ArrayList<Model> getAllCities(Connection connection) {
        String sql = "SELECT * FROM city ORDER BY population DESC;";
        try {
            ResultSet results = connection.createStatement().executeQuery(sql);

            ArrayList<Model> cities = new ArrayList<Model>();

            while( results.next() ) {
                City city = new City();

                city.setId( results.getInt("ID") );
                city.setCountryCode( results.getString("CountryCode") );
                city.setDistrict( results.getString("District") );
                city.setName( results.getString("Name") );
                city.setPopulation( results.getInt("Population") );

                cities.add(city);
            }

            return cities;
        } catch( Exception e ) {
            System.out.println(e.getMessage());
            return null;
        }

    }
}
