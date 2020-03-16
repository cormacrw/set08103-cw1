package com.napier.sem.pages.Country.Form;


import com.napier.sem.data.Datasource;
import com.napier.sem.html.HTMLFormBuilder;
import com.napier.sem.html.HTMLPageBuilder;
import com.napier.sem.query.RegionsQuery;

import java.sql.Connection;
import java.util.ArrayList;

public class CountryRegionForm {
    public String build() {
        String url = "/report/country/region";

        Connection conn = Datasource.getDatabase();

        ArrayList<String> regions = RegionsQuery.getRegions(conn);

        return new HTMLPageBuilder()
                .addHeader("Country Form")
                .appendToBody( new HTMLFormBuilder(url).addSelectFormInput("Region", regions).addLimitFormInput().build() )
                .build();
    }
}
