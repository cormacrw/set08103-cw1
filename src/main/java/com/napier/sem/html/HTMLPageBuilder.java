package com.napier.sem.html;

import javax.swing.text.html.HTML;

public class HTMLPageBuilder extends HTMLBuilder {


    public HTMLPageBuilder() {
        append("<html><head><title>SEM Coursework</title></head><body>");
    }

    public HTMLPageBuilder addHeader( String header ) {
        append("<h1>" + header + "</h1>");

        return this;
    }

    public HTMLPageBuilder addBody( String body ) {
        append(body);
        return this;
    }

    public String build() {
        append("</body></html>");
        return super.build();
    }
}
