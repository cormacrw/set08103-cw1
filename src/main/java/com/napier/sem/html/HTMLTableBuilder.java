package com.napier.sem.html;

import java.util.ArrayList;

/**
 * Class for building up HTML Table string dynamically
 */
public class HTMLTableBuilder extends HTMLBuilder{


    public HTMLTableBuilder() {
        super();
        append("<table>");
    }



    public HTMLTableBuilder addHeaders( ArrayList<String> headers ) {

        append("<thead>");

        for( int i = 0; i < headers.size(); i++) {
            append( "<th>");
            append( headers.get(i) );
            append( "</th>");
        }

        append("</thead>");

        return this;
    }

    public HTMLTableBuilder addRows( ArrayList<String> rows ) {
        append("<tbody>");
        for( int i = 0; i < rows.size(); i++) {
            append( "<tr>");
            append( "</tr>");
        }

        append("</tbody>");

        return this;
    }
}
