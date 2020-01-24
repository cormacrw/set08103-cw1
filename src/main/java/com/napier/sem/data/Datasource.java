package com.napier.sem.data;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

/**
 * Class that handles connecting to database. Uses singleton method to ensure that no more than one connection is made
 * to the database.
 */
public class Datasource {

    private static final String DB_NAME = "mydb";
    private static final String DB_HOST = "mydb";
    private static final int DB_PORT = 27000;

    private MongoDatabase database;
    private static Datasource datasource;
    private Datasource() {

        MongoClient mongoClient = new MongoClient(DB_HOST, DB_PORT);

        database = mongoClient.getDatabase(DB_NAME);
    }

    public static MongoDatabase getDatabase() {
        if( datasource == null ) {
            datasource = new Datasource();
        }

        return datasource.database;
    }
}
