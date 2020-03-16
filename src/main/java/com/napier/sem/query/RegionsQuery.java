package com.napier.sem.query;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RegionsQuery {
    public static ArrayList<String> getRegions(Connection conn) {
        String sql = "SELECT DISTINCT Region FROM country;";

        try {
            ResultSet resultSet = conn.createStatement().executeQuery(sql);
            ArrayList<String> regions = new ArrayList<>();
            while (resultSet.next()){
                regions.add(resultSet.getString(1));
            }
            return regions;

        }catch(Exception e){
            return null;
        }
    }
}
