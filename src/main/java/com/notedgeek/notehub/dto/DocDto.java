package com.notedgeek.notehub.dto;

import com.notedgeek.notehub.entity.Doc;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class DocDto {

    private long id;
    private String markdown;
    private String html;
    private Date dateCreated;
    private Date dateUpdated;
    private List<String> tags;

    public static DocDto fromEntity(Doc doc) {
        List<String> tags = doc.getTagLinks().stream()
            .map(tl -> tl.getTag().getValue()).collect(Collectors.toList());
        return new DocDto(
            doc.getId(),
            doc.getMarkdown(),
            doc.getHtml(),
            doc.getDateCreated(),
            doc.getDateUpdated(),
            tags
        );
    }

    private DocDto(long id, String markdown, String html, Date dateCreated, Date dateUpdated, List<String> tags) {
        this.id = id;
        this.markdown = markdown;
        this.html = html;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
        this.tags = tags;
    }

    public long getId() {
        return id;
    }

    public String getMarkdown() {
        return markdown;
    }

    public String getHtml() {
        return html;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public List<String> getTags() {
        return tags;
    }
}
