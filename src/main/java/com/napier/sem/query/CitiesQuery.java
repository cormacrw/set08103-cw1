package com.napier.sem.query;

import com.napier.sem.models.City;
import com.napier.sem.models.Country;
import com.napier.sem.models.Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

public class CitiesQuery {
    public static ArrayList getAllCities(Connection connection, HashMap<String, Object> params) {
        String sql = "SELECT * FROM city left join country ON country.code = city.Countrycode";
        if (params.containsKey("region")) {
            sql += " WHERE Region = " + params.get("region");
        }

        if (params.containsKey("continent")) {

            sql += " WHERE Continent = '" + params.get("continent") + "'";
        }

        sql += " ORDER BY city.population DESC";

        if (params.containsKey("limit")) {
            if ((int) params.get("limit") > 0) {
                sql += " LIMIT " + params.get("limit");
            }
        }
            sql += ";";

            System.out.println(sql);
            try {

                ResultSet results = connection.createStatement().executeQuery(sql);

                ArrayList<Model> cities = new ArrayList<>();

                while (results.next()) {
                    City city = new City();

                    city.setName(results.getString("Name"));
                    city.setId(results.getInt("ID"));
                    city.setCountryCode(results.getString("CountryCode"));
                    city.setDistrict(results.getString("District"));
                    city.setPopulation(results.getInt("Population"));

                    cities.add(city);

                }
                System.out.println(cities.size());
                return cities;

            } catch (Exception e) {

                System.out.println(e.getMessage());

            }

            return null;

        }
    }
