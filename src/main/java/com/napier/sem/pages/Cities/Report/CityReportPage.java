package com.napier.sem.pages.Cities.Report;
import com.napier.sem.data.Datasource;
import com.napier.sem.html.HTMLPageBuilder;
import com.napier.sem.html.HTMLTableBuilder;
import com.napier.sem.models.Model;
import com.napier.sem.query.CitiesQuery;
import com.napier.sem.query.CountriesQuery;
import com.napier.sem.query.TestQuery;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

public class CityReportPage {
    HashMap<String, Object> params;

    public CityReportPage(HashMap<String, Object> _params) {
        params = _params;
    }

    public String build() {
        Connection conn = Datasource.getDatabase();

        ArrayList<Model> Cities = CitiesQuery.getAllCities(conn, params);
        System.out.println(Cities.size());
        return new HTMLPageBuilder()
                .addHeader("Cities Report")
                .appendToBody(new HTMLTableBuilder().populate(Cities).build())
                .build();
    }
}
