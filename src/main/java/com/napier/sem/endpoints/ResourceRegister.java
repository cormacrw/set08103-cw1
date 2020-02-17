package com.napier.sem.endpoints;

import com.sun.net.httpserver.HttpServer;

/**
 * Class that registers the request filter to listen on the root path.
 */
public class ResourceRegister {

    private HttpServer httpServer;

    public ResourceRegister( HttpServer _httpServer ) {
        httpServer = _httpServer;
    }

    public void register() {
        httpServer.createContext( RequestFilter.PATH, new RequestFilter() );
    }
}
