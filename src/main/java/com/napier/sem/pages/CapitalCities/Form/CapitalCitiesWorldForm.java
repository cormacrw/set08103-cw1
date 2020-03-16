package com.napier.sem.pages.CapitalCities.Form;

import com.napier.sem.html.HTMLFormBuilder;
import com.napier.sem.html.HTMLPageBuilder;

public class CapitalCitiesWorldForm {
    public String build() {
        String url = "/report/CapitalCities/all";

        return new HTMLPageBuilder().addHeader("Capital Cities in the World")
                .appendToBody( new HTMLFormBuilder(url).addLimitFormInput().build() )
                .build();
    }
}
