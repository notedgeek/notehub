package com.notedgeek.notehub.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

import static javax.persistence.GenerationType.AUTO;

@Entity
public class Tag {

    @Id
    @GeneratedValue(strategy = AUTO)
    private long id;

    private String value;

    @ManyToMany(mappedBy = "tags")
    private List<Doc> docs;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<Doc> getDocs() {
        return docs;
    }

    public void setDocs(List<Doc> docs) {
        this.docs = docs;
    }
}
