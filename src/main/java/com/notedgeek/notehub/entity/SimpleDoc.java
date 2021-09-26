package com.notedgeek.notehub.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.AUTO;

@Entity
public class SimpleDoc {

    @Id
    @GeneratedValue(strategy = AUTO)
    private long id;

    private String markup;

    private String html;

    public long getId() {
        return id;
    }

    public String getMarkup() {
        return markup;
    }

    public void setMarkup(String markup) {
        this.markup = markup;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }
}
