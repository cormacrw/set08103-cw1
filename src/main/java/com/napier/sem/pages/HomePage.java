package com.napier.sem.pages;

import com.napier.sem.data.TextFileReader;
import com.napier.sem.elements.ListItem;
import com.napier.sem.html.HTMLListBuilder;
import com.napier.sem.html.HTMLPageBuilder;

import java.util.ArrayList;

public class HomePage {
    public String build() {
        ArrayList<ListItem> listItems = TextFileReader.getListItems("/tmp/homeListItems.txt");

        return new HTMLPageBuilder()
                .addHeader("Home Page")
                .appendToBody( new HTMLListBuilder().addItems( listItems ).build() )
                .build();
    }
}
