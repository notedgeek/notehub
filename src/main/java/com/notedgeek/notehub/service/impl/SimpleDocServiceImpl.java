package com.notedgeek.notehub.service.impl;

import com.notedgeek.notehub.entity.SimpleDoc;
import com.notedgeek.notehub.repository.SimpleDocRepository;
import com.notedgeek.notehub.service.SimpleDocService;
import com.notedgeek.notehub.util.AsciidoctorConverter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimpleDocServiceImpl implements SimpleDocService {

    private final SimpleDocRepository repository;
    private final AsciidoctorConverter converter;

    public SimpleDocServiceImpl(SimpleDocRepository repository, AsciidoctorConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public List<SimpleDoc> listAll() {
        return null;
    }

    @Override
    public void save(SimpleDoc simpleDoc) {
        simpleDoc.setHtml(converter.convert(simpleDoc.getMarkup()));
        repository.save(simpleDoc);
    }
}
