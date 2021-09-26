package com.notedgeek.notehub.service;

import com.notedgeek.notehub.entity.SimpleDoc;

public interface SimpleDocService {

    Iterable<SimpleDoc> listAll();

    void save(SimpleDoc simpleDoc);

}
