package com.napier.sem.endpoints;


import com.napier.sem.pages.HomePage;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;

public class HomeEndpoint {

    private HttpExchange exchange;

    public HomeEndpoint( HttpExchange e ) {
        exchange = e;
    }

    public void buildResponse() throws IOException {
        String html = new HomePage().build();

        exchange.sendResponseHeaders(404, html.getBytes().length);
        OutputStream os = exchange.getResponseBody();
        os.write(html.getBytes());
        os.close();
    }
}
