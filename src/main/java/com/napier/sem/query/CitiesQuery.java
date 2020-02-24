package com.napier.sem.query;

import java.sql.Connection;
import java.util.HashMap;

public class CitiesQuery {
    public static void getAllCities(Connection connection, HashMap<String, Object> params ) {
        String sql = "SELECT * FROM city";

        if( params.containsKey("limit") ) {
            sql += " LIMIT " + params.get("limit");
        }

        sql += ";";
        
    }
}
