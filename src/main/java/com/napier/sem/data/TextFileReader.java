package com.napier.sem.data;

import com.napier.sem.elements.ListItem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TextFileReader {

    public static ArrayList<ListItem> getListItems() {
        String filePath = "/tmp/homeListItems.txt";
        System.out.println(filePath);
        BufferedReader reader;
        ArrayList<ListItem> listItems = new ArrayList<ListItem>();
        try {
            reader = new BufferedReader( new FileReader( filePath ) );
            String line = reader.readLine();
            while( line != null ) {
                String[] listProperties = line.split(",");
                listItems.add( new ListItem( listProperties[0], listProperties[1] ) );

                line = reader.readLine();
            }

            return listItems;
        } catch ( IOException e ) {
            e.printStackTrace();
            return null;
        }
    }
}