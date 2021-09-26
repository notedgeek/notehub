package com.notedgeek.notehub.service.impl;

import com.notedgeek.notehub.entity.Doc;
import com.notedgeek.notehub.repository.DocRepository;
import com.notedgeek.notehub.service.DocService;
import com.notedgeek.notehub.util.AsciidoctorConverter;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class DocServiceImpl implements DocService {

    private final DocRepository repository;
    private final AsciidoctorConverter converter;

    public DocServiceImpl(DocRepository repository, AsciidoctorConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public Iterable<Doc> listAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Doc> findById(long id) {
        return repository.findById(id);
    }

    @Override
    public void save(Doc doc) {
        doc.setHtml(converter.convert(doc.getMarkdown()));
        Date date = new Date();
        doc.setDateUpdated(date);
        if(doc.getDateCreated() == null) {
            doc.setDateCreated(date);
        }
        repository.save(doc);
    }
}
