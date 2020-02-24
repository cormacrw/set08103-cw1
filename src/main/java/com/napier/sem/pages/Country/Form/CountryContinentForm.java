package com.napier.sem.pages.Country.Form;

import com.napier.sem.data.Datasource;
import com.napier.sem.html.HTMLFormBuilder;
import com.napier.sem.html.HTMLPageBuilder;
import com.napier.sem.query.ContinentsQuery;

import java.sql.Connection;
import java.util.ArrayList;

public class CountryContinentForm {
    public String build() {
        String url = "/report/country/continent";

        Connection conn = Datasource.getDatabase();

        ArrayList<String> continents = ContinentsQuery.getContinents(conn);

        return new HTMLPageBuilder()
                .addHeader("Country Form")
                .appendToBody( new HTMLFormBuilder(url)
                        .addLimitFormInput()
                        .addSelectFormInput("Continent", continents)
                        .build())
                .build();
    }
}
