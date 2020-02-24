package com.napier.sem.html;

import javax.swing.text.html.HTML;

public class HTMLPageBuilder extends HTMLBuilder {


    public HTMLPageBuilder() {

        append("<html><head><title>SEM Coursework</title><link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\" integrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\" crossorigin=\"anonymous\"></head><body>");
    }

    public HTMLPageBuilder addHeader( String header ) {
        append("<h1>" + header + "</h1>");

        return this;
    }

    public HTMLPageBuilder appendToBody( String body ) {
        append(body);
        return this;
    }

    public String build() {
        append("</body></html>");
        return super.build();
    }
}
