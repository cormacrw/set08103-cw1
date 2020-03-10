package com.napier.sem.endpoints;

import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;

public class RequestFilter extends AbstractEndpoint {

    public static final String PATH = "/";

    @Override
    public void handle(HttpExchange exchange) throws IOException {

        if( exchange.getRequestURI().getRawPath().equals("/") ) {
            new HomeEndpoint( exchange ).buildResponse();
            return;
        }

        if( exchange.getRequestURI().getRawPath().equals("/data-test") ) {
            new DataTestEndpoint( exchange ).buildResponse();
            return;
        }
        System.out.println(exchange.getRequestURI().getRawPath());
        String[] pathArr = exchange.getRequestURI().getRawPath().split("/");

        if( pathArr[2].equals("country") ) {
            new CountryEndpoint( exchange, pathArr ).buildResponse();
            return;
        }
        if( pathArr[2].equals("cities") ) {
            new CitiesEndpoint( exchange, pathArr ).buildResponse();
            return;
        }

        // if we have gotten here we can assume resource was not located so send 404
        String response = "resource not found";
        exchange.sendResponseHeaders(404, response.getBytes().length);
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

}
