package com.napier.sem.html;

public class HTMLBuilder {
    private StringBuilder htmlString;

    public HTMLBuilder() {
        htmlString = new StringBuilder();
    }

    public void append( String str ) {
        htmlString.append(str);
    }

    public String build() {
        return htmlString.toString();
    }
}
