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


        System.out.println(exchange.getRequestURI().getRawPath());
        String[] pathArr = exchange.getRequestURI().getRawPath().split("/");

        if( pathArr[1].equals("report") && pathArr.length > 3 ) {

            if( pathArr[2].equals("city") ) {

            }
        }

        int a = 2;
        // if we have gotten here we can assume resource was not located so send 404
        String response = "resource not found";
        exchange.sendResponseHeaders(404, response.getBytes().length);
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
