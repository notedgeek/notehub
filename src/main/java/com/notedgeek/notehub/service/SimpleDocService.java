package com.notedgeek.notehub.service;

import com.notedgeek.notehub.entity.SimpleDoc;

import java.util.List;

public interface SimpleDocService {

    List<SimpleDoc> listAll();

    void save(SimpleDoc simpleDoc);

}
