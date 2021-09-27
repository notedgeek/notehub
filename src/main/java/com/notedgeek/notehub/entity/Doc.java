package com.notedgeek.notehub.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static javax.persistence.GenerationType.AUTO;

@Entity
public class Doc {

    @Id
    @GeneratedValue(strategy = AUTO)
    private long id;

    @Lob
    private String markdown;

    @Lob
    private String html;

    private Date dateCreated;

    private Date dateUpdated;

    @OneToMany(mappedBy = "doc")
    private List<TagLink> tagLinks = new ArrayList<>();

    public long getId() {
        return id;
    }

    public String getMarkdown() {
        return markdown;
    }

    public void setMarkdown(String markdown) {
        this.markdown = markdown;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public List<TagLink> getTagLinks() {
        return tagLinks;
    }

}
