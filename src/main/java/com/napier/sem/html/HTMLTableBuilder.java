package com.napier.sem.html;

import com.napier.sem.models.Model;

import java.util.ArrayList;

public class HTMLTableBuilder extends HTMLBuilder{


    public HTMLTableBuilder() {
        super();
        append("<table class=\"table table-striped\">");
    }

    public HTMLTableBuilder populate( ArrayList<Model> data ) {
        addHeaders(data.get(0));
        addRows(data);

        return this;
    }

    private HTMLTableBuilder addHeaders( Model model ) {

        ArrayList<String> headers = model.getHeaders();
        append("<thead class=\"thead-dark\">");
        for( int i = 0; i < headers.size(); i++) {
            append( "<th>");
            append( headers.get(i) );
            append( "</th>");
        }

        append("</thead>");

        return this;
    }

    private HTMLTableBuilder addRows( ArrayList<Model> rows ) {
        append("<tbody>");
        for( int i = 0; i < rows.size(); i++) {
            append( "<tr>");
            ArrayList<String> values = rows.get(i).getValues();
            values.forEach(value -> {
                append("<td>");
                append(value);
                append("</td>");
            });
            append( "</tr>");
        }

        append("</tbody>");

        return this;
    }

    public String build() {
        append("</table>");
        return super.build();
    }
}
