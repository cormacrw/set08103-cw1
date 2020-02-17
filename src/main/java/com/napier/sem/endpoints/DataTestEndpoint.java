package com.napier.sem.endpoints;

import com.napier.sem.pages.TestDataPage;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Endpoint to test database connection
 */
public class DataTestEndpoint {

    private HttpExchange exchange;

    public DataTestEndpoint( HttpExchange _exchange ) {
        exchange = _exchange;
    }

    public void buildResponse() throws IOException {
        String html = new TestDataPage().build();

        exchange.sendResponseHeaders(404, html.getBytes().length);
        OutputStream os = exchange.getResponseBody();
        os.write(html.getBytes());
        os.close();
    }
}
