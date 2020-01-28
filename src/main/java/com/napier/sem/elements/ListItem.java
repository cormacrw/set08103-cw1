package com.napier.sem.elements;

public class ListItem {
    private String title, uri;

    public ListItem( String _title, String _uri ) {
        title = _title;
        uri = _uri;
    }

    public String getUri() {
        return uri;
    }

    public String getTitle() {
        return title;
    }
}
