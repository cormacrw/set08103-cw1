package com.napier.sem.pages.Population;

import com.napier.sem.data.Datasource;
import com.napier.sem.html.HTMLPageBuilder;
import com.napier.sem.html.HTMLTableBuilder;
import com.napier.sem.models.Model;
import com.napier.sem.models.Population;
import com.napier.sem.query.PopulationQuery;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

public class PopulationReportPage {
    ArrayList<Model> populations;

    public PopulationReportPage( ArrayList<Model> _populations ) {
        populations = _populations;
    }

    public String build() {

        return new HTMLPageBuilder()
                .addHeader("Population Report")
                .appendToBody( new HTMLTableBuilder().populate(populations).build())
                .build();


    }



}
