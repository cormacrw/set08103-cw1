package com.napier.sem.data;

import java.sql.*;

/**
 * Class that handles connecting to database. Uses singleton method to ensure that no more than one connection is made
 * to the database.
 */
public class Datasource {

    private static final String DB_NAME = "mydb";
    private static final String DB_HOST = "localhost";
    private static final int DB_PORT = 27000;

    private static Connection connection;
    private Datasource() {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.out.print(e.getMessage());
            System.exit(-1);
        }

        // Connection to the database
        Connection con = null;
        int retries = 100;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/employees?useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                // Wait a bit
                Thread.sleep(10000);
                // Exit for loop
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    public static Connection getDatabase() {
        if( connection == null ) {
            new Datasource();
        }

        return connection;
    }
}
