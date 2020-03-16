package com.napier.sem.query;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ContinentsQuery {
    public static ArrayList<String> getContinents( Connection conn ) {
        String sql = "SELECT DISTINCT Continent FROM country";

        try {
            ResultSet results = conn.createStatement().executeQuery(sql);

            ArrayList<String> continents = new ArrayList<>();

            while( results.next() ) {
                continents.add( results.getString("Continent") );
            }

            return continents;
        } catch (Exception e) {
            return null;
        }
    }
}
