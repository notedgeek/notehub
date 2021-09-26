package com.notedgeek.notehub.service;

import com.notedgeek.notehub.entity.Doc;

import java.util.List;
import java.util.Optional;

public interface DocService {

    List<Doc> listAll();

    Optional<Doc> findById(long id);

    Doc save(Doc doc);

}
