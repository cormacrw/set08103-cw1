package com.napier.sem.pages.Country.Form;

import com.napier.sem.html.HTMLFormBuilder;
import com.napier.sem.html.HTMLPageBuilder;

public class CountryWorldForm {
    public String build() {
        String url = "/report/country/all";

        return new HTMLPageBuilder().addHeader("Cities in the World")
                .appendToBody( new HTMLFormBuilder(url).addLimitFormInput().build() )
                .build();
    }
}
