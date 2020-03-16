package com.napier.sem.endpoints;

import com.napier.sem.data.Datasource;
import com.napier.sem.models.Model;
import com.napier.sem.pages.Population.PopulationReportPage;
import com.napier.sem.query.PopulationQuery;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.util.ArrayList;

public class PopulationEndpoint {
    String[] pathArr;
    HttpExchange exchange;

    public PopulationEndpoint(HttpExchange _exchange, String[] path) {
        exchange = _exchange;
        pathArr = path;
    }
    public void buildResponse() throws IOException {
        String html = "";
        Connection conn = Datasource.getDatabase();
        if (pathArr[3].equals("country")){
            ArrayList<Model> populations = PopulationQuery.getPopulationByCountry(conn);

            html = new PopulationReportPage( populations ).build();
        } else if (pathArr[3].equals ("region")){
            ArrayList<Model> populations = PopulationQuery.getPopulationByRegion(conn);
            html = new PopulationReportPage( populations ).build();
        }
        else if (pathArr[3].equals ("continent")) {
            ArrayList<Model> populations = PopulationQuery.getPopulationByContinent(conn);
            html = new PopulationReportPage( populations ).build();
        }


        exchange.sendResponseHeaders(200, html.getBytes().length);
        OutputStream os = exchange.getResponseBody();
        os.write(html.getBytes());
        os.close();
    }
}

