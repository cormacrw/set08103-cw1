package com.napier.sem.pages.CapitalCities.Form;

import com.napier.sem.data.Datasource;
import com.napier.sem.html.HTMLFormBuilder;
import com.napier.sem.html.HTMLPageBuilder;
import com.napier.sem.models.Country;
import com.napier.sem.query.CitiesQuery;
import com.napier.sem.query.ContinentsQuery;

import java.sql.Connection;
import java.util.ArrayList;

public class CapitalCitiesContinentForm {
    public String build() {
        String url = "/report/CapitalCities/continent";

        Connection conn = Datasource.getDatabase();

        ArrayList<String> CapitalCities = ContinentsQuery.getContinents(conn);

        return new HTMLPageBuilder()
                .addHeader("Capital City Form")
                .appendToBody( new HTMLFormBuilder(url)
                        .addLimitFormInput()
                        .addSelectFormInput("Country", CapitalCities)
                        .build())
                .build();
    }
}
