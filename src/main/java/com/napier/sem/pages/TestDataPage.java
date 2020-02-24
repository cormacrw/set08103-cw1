package com.napier.sem.pages;

import com.napier.sem.data.Datasource;
import com.napier.sem.html.HTMLPageBuilder;
import com.napier.sem.html.HTMLTableBuilder;
import com.napier.sem.models.City;
import com.napier.sem.models.Model;
import com.napier.sem.query.TestQuery;

import java.sql.Connection;
import java.util.ArrayList;

public class TestDataPage {

    public String build() {
        Connection conn = Datasource.getDatabase();

        ArrayList<Model> cities = TestQuery.getAllCities(conn);

        return new HTMLPageBuilder()
                .addHeader("Test Endpoint")
                .appendToBody( new HTMLTableBuilder().populate(cities).build() )
                .build();
    }
}
