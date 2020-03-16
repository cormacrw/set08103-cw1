package com.napier.sem.pages.Country.Report;

import com.napier.sem.data.Datasource;
import com.napier.sem.html.HTMLPageBuilder;
import com.napier.sem.html.HTMLTableBuilder;
import com.napier.sem.models.Model;
import com.napier.sem.query.CountriesQuery;
import com.napier.sem.query.TestQuery;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

public class CountryReportPage {

    HashMap<String, Object> params;

    public CountryReportPage(HashMap<String, Object> _params ) {
        params = _params;
    }

    public String build() {
        Connection conn = Datasource.getDatabase();

        ArrayList<Model> countries = CountriesQuery.getCountries(conn, params);

        return new HTMLPageBuilder()
                .addHeader("Countries.md Report")
                .appendToBody( new HTMLTableBuilder().populate(countries).build() )
                .build();
    }
}
