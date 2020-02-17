package com.napier.sem.html;

/**
 * Base class for building up HTML Strings
 */
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
