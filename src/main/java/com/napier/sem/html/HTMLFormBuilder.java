package com.napier.sem.html;

import java.util.ArrayList;

public class HTMLFormBuilder extends HTMLBuilder {
    public HTMLFormBuilder( String url ) {
        super();
        append("<form class=\"w-25\" method=\"POST\" action=\"" + url +"\">");
    }

    public HTMLFormBuilder addLimitFormInput() {
        append("<div class=\"form-group\"");
        append("<label for=\"limit\">Limit Results</label>");
        append("<input class=\"form-control\" type=\"number\" name=\"limit\" value=\"0\" required>");
        append("</div>");

        return this;
    }

    public HTMLFormBuilder addTextFormInput(String name) {
        append("<div class=\"form-group\">");
        append("<label for=\"" + name + "\">" + name + "</label>");
        append("<input class=\"form-control\" type=\"text\" name=\"" + name + "\" required>");
        append("</div>");

        return this;
    }

    public HTMLFormBuilder addSelectFormInput(String name, ArrayList<String> items) {
        append("<div class=\"form-group\">");
        append("<label for=\"" + name + "\">" + name + "</label>");
        append("<select class=\"form-control\" name=\"" + name.toLowerCase() + "\" >");
        for(int i = 0; i < items.size(); i++) {
            append("<option>" + items.get(i) + "</option>");
        }
        append("</select>");
        append("</div>");

        return this;
    }

    public String build() {
        append("<button class=\"btn btn-primary\" type=\"submit\">Go!</button>");
        append("</form>");
        return super.build();
    }
}
