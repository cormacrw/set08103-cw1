package com.napier.sem.endpoints;

import com.napier.sem.data.RequestBodyReader;
import com.napier.sem.pages.Cities.Form.CitiesContinentForm;
import com.napier.sem.pages.Cities.Form.CitiesRegionForm;
import com.napier.sem.pages.Cities.Form.CitiesWorldForm;
import com.napier.sem.pages.Cities.Report.CityReportPage;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;


public class CitiesEndpoint {
    String[] pathArr;
    HttpExchange exchange;

    public CitiesEndpoint(HttpExchange _exchange, String[] path) {
        exchange = _exchange;
        pathArr = path;
    }

    public void buildResponse() throws IOException {
        String html = "";
        if (pathArr[1].equals("form")) {
            if (pathArr[3].equals("all")) {
                html = new CitiesWorldForm().build();
 //          } else if (pathArr[3].equals("region")) {
//                html = new CitiesRegionForm().build();
            } else if (pathArr[3].equals("continent")) {
                html = new CitiesContinentForm().build();
            }
        } else if (pathArr[1].equals("report")) {
            System.out.println("test");
            HashMap<String, Object> body = new RequestBodyReader(exchange.getRequestBody()).getBodyParams();
            html = new CityReportPage(body).build();
        }

        exchange.sendResponseHeaders(200, html.getBytes().length);
        OutputStream os = exchange.getResponseBody();
        os.write(html.getBytes());
        os.close();
    }
}
