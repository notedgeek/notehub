package com.notedgeek.notehub.service;

import com.notedgeek.notehub.entity.Doc;

import java.util.Optional;

public interface DocService {

    Iterable<Doc> listAll();

    Optional<Doc> findById(long id);

    void save(Doc doc);

}
