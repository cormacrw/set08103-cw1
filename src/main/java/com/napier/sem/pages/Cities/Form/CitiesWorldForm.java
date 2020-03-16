package com.napier.sem.pages.Cities.Form;

import com.napier.sem.data.Datasource;
import com.napier.sem.html.HTMLFormBuilder;
import com.napier.sem.html.HTMLPageBuilder;
import com.napier.sem.query.ContinentsQuery;

import java.sql.Connection;
import java.util.ArrayList;

public class CitiesWorldForm {
    public String build() {
        String url = "/report/cities/all";

        return new HTMLPageBuilder().addHeader("Cities in the World")
                .appendToBody( new HTMLFormBuilder(url).addLimitFormInput().build() )
                .build();
    }
}
