package com.napier.sem.pages;

import com.napier.sem.data.Datasource;
import com.napier.sem.html.HTMLPageBuilder;

import java.sql.Connection;

public class TestDataPage {

    public String build() {
        Connection conn = Datasource.getDatabase();

        return new HTMLPageBuilder().addHeader("Test Endpoint").build();
    }
}
