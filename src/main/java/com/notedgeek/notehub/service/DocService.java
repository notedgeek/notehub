package com.notedgeek.notehub.service;

import com.notedgeek.notehub.entity.Doc;

public interface DocService {

    Iterable<Doc> listAll();

    void save(Doc doc);

}
