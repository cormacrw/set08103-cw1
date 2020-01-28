package com.napier.sem;

import com.napier.sem.endpoints.ResourceRegister;
import com.sun.net.httpserver.HttpServer;

import java.net.InetSocketAddress;

/**
 * Entry point for program
 */
public class App {

    public static String HOST_NAME = "localhost";
    public static int HOST_PORT = 3000;

    private HttpServer httpServer;

    public App() {

        try {
            httpServer = HttpServer.create( new InetSocketAddress( HOST_NAME, HOST_PORT ), 0);

            // register all routes
            new ResourceRegister( httpServer ).register();

            // start the web server
            httpServer.start();

            System.out.println("Web server successfully started on port " + HOST_PORT + "!");
        } catch( Exception e ) {
            System.out.println("WEB SERVER COULD NOT START!");
        }
    }


    public static void main( String[] args ) {
        System.out.println("Starting web server...");

        new App();

    }
}
