package com.napier.sem.endpoints;

import com.napier.sem.data.RequestBodyReader;
import com.napier.sem.pages.Country.Form.CountryContinentForm;
import com.napier.sem.pages.Country.Form.CountryWorldForm;
import com.napier.sem.pages.Country.Report.CountryReportPage;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;

public class CountryEndpoint {

    String[] pathArr;
    HttpExchange exchange;

    public CountryEndpoint(HttpExchange _exchange, String[] path) {
        exchange = _exchange;
        pathArr = path;
    }

    public void buildResponse() throws IOException {
        String html = "";
        if( pathArr[1].equals("form") ) {
            if( pathArr[3].equals("all") ) {
                html = new CountryWorldForm().build();
            } else if (pathArr[3].equals("region")) {
//                html = new CountryRegionForm().build();
            } else if( pathArr[3].equals("continent") ) {
                html = new CountryContinentForm().build();
            }
        } else if( pathArr[1].equals("report") ) {
            HashMap<String, Object> body = new RequestBodyReader(exchange.getRequestBody()).getBodyParams();
            html = new CountryReportPage(body).build();
        }

        exchange.sendResponseHeaders(200, html.getBytes().length);
        OutputStream os = exchange.getResponseBody();
        os.write(html.getBytes());
        os.close();
    }
}
