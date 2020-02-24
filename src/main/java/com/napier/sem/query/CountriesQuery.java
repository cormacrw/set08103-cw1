package com.napier.sem.query;

import com.napier.sem.models.Country;
import com.napier.sem.models.Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

public class CountriesQuery {
    public static ArrayList<Model> getCountries(Connection connection, HashMap<String, Object> params ) {
        String sql = "SELECT * FROM country";

        if( params.containsKey("region") ) {
            sql += " WHERE Region = " + params.get("region");
        }

        if( params.containsKey("continent") ) {
            sql += " WHERE Continent = '" + params.get("continent") + "'";
        }

        sql += " ORDER BY population DESC";

        if( params.containsKey("limit") ) {
            if( (int) params.get("limit") > 0 ) {
                sql += " LIMIT " + params.get("limit");
            }
        }

        sql += ";";

        System.out.println(sql);
        try {
            ResultSet results = connection.createStatement().executeQuery(sql);

            ArrayList<Model> countries = new ArrayList<>();

            while( results.next() ) {
                Country country = new Country();

                country.setName( results.getString("Name") );
                country.setCode( results.getString("Code") );
                country.setContinent( results.getString("Continent") );
                country.setRegion( results.getString("Region") );
                country.setCapital( results.getString("Capital") );
                country.setPopulation( results.getInt("Population") );

                countries.add(country);
            }
            System.out.println(countries.size());
            return countries;

        } catch( Exception e ) {

        }

        return null;
    }
}
