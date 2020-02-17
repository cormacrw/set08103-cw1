package com.napier.sem.html;

import com.napier.sem.elements.ListItem;

import java.util.ArrayList;

public class HTMLListBuilder extends HTMLBuilder {
    public HTMLListBuilder() {
        super();
        append("<ul>");
    }

    public HTMLListBuilder addItems(ArrayList<ListItem> listItems ) {
        for( int i = 0; i < listItems.size(); i++ ) {
            ListItem item = listItems.get(i);
            append( "<li><a href=\"" + item.getUri() + "\">" + item.getTitle() + "</a></li>" );
        }

        return this;
    }

    public String build() {
        append("</ul>");
        return super.build();
    }
}
