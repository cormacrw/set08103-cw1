package com.napier.sem.query;

import com.napier.sem.models.Model;
import com.napier.sem.models.Population;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PopulationQuery {
    public static ArrayList<Model> getPopulationByCountry (Connection conn) {
        String sql = "select country.Name, country.Population, ROUND(SUM(city.Population) / country.Population * 100,1) as popInCity, ROUND((country.Population - SUM(city.Population)) / country.Population * 100, 1) as popOutCity from country join city on country.Code = city.CountryCode GROUP BY country.Code;";

        try {
            ResultSet resultSet = conn.createStatement().executeQuery(sql);
            return extractPopulations( resultSet );

        }catch (Exception e){
            return null;
        }
    }

    public static ArrayList<Model> getPopulationByRegion (Connection conn) {
        String sql = "select Region, Name, cityPopulation, regionPopulation as Population, round((cityPopulation/regionPopulation)*100,2) as popInCity, round(((regionPopulation-cityPopulation)/regionPopulation)*100,2) as popOutCity from ( select Region, name, population as cityPopulation, (select sum(co2.Population) from country co2 where co2.code = CountryCode) as regionPopulation from ( select co.Region, ci.name, ci.CountryCode, ci.Population from city ci left join country co on ci.CountryCode = co.Code group by co.Region,ci.Name, ci.CountryCode, ci.Population) as subqry ) as subqry2 order by Region,Name;\n";

        try {
            ResultSet resultSet = conn.createStatement().executeQuery(sql);

            return extractPopulations(resultSet);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    public static ArrayList<Model> getPopulationByContinent (Connection conn) {
        String sql = "";
        try {
            ResultSet resultSet = conn.createStatement().executeQuery(sql);
            return extractPopulations( resultSet );

        }catch (Exception e){
            return null;
        }
    }



    private static ArrayList<Model> extractPopulations( ResultSet resultSet ) throws SQLException {
        ArrayList<Model> populations = new ArrayList<>();
        while (resultSet.next()) {
            Population population = new Population();
            population.setName(resultSet.getString("Name"));
            population.setPopulation(resultSet.getInt("Population"));
            population.setInCities(resultSet.getDouble("popInCity"));
            population.setOutCities(resultSet.getDouble("popOutCity"));
            populations.add(population);
        }
        return populations;
    }
}
