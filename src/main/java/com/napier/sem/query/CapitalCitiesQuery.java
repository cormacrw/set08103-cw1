package com.napier.sem.query;

import com.napier.sem.models.City;
import com.napier.sem.models.Model;

import java.sql.ResultSet;
import java.util.ArrayList;

public class CapitalCitiesQuery {
//    public static ArrayList<Model> getCapitalCities(Connection conn, HashMap<String, Object> params) {
//        String sql = "SELECT * as capitalName from country left join  city on country.Capital = city.ID";
//
//        try {
//            ResultSet results = conn.createStatement().executeQuery(sql);
//
//            ArrayList<Model> capitals = new ArrayList<>();
//
//            while (results.next()) {
//                City city = new City();
//
//                city.setId(results.getInt("ID"));
//                city.setCountryCode(results.getString("CountryCode"));
//                city.setDistrict(results.getString("District"));
//                city.setName(results.getString("Name"));
//                city.setPopulation(results.getInt("Population"));
//
//                capitals.add(city);
//            }
//
//            return capitals;
//        } catch (Exception e) {
//            return null;
//        }
//    }
}



