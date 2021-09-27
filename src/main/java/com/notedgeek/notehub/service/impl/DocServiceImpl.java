package com.notedgeek.notehub.service.impl;

import com.notedgeek.notehub.entity.Doc;
import com.notedgeek.notehub.entity.Tag;
import com.notedgeek.notehub.repository.DocRepository;
import com.notedgeek.notehub.service.DocService;
import com.notedgeek.notehub.service.TagService;
import com.notedgeek.notehub.util.AsciidoctorConverter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DocServiceImpl implements DocService {

    private final DocRepository repository;
    private final AsciidoctorConverter converter;
    private final TagService tagService;

    public DocServiceImpl(DocRepository repository, AsciidoctorConverter converter, TagService tagService) {
        this.repository = repository;
        this.converter = converter;
        this.tagService = tagService;
    }

    @Override
    public List<Doc> listAll() {
        List<Doc> docs = new ArrayList<>();
        docs.addAll(repository.findAll());
        docs.sort(Comparator.comparing(Doc::getDateUpdated).reversed());
        return docs;
    }

    @Override
    public Optional<Doc> findById(long id) {
        return repository.findById(id);
    }

    @Override
    public Doc save(Doc doc) {
        doc.setHtml(converter.convert(doc.getMarkdown()));
        Date date = new Date();
        doc.setDateUpdated(date);
        if(doc.getDateCreated() == null) {
            doc.setDateCreated(date);
        }
        return repository.save(doc);
    }

    @Override
    public void setTags(Doc doc, Iterable<String> tagValues) {
        List<Tag> tags = doc.getTags();
        tags.clear();
        for(String tagValue: tagValues) {
            tags.add(tagService.ensureTag(tagValue));
        }
    }

    @Override
    public void addTag(Doc doc, String tagValue) {
        Tag tag = tagService.ensureTag(tagValue);
        doc.getTags().add(tag);
    }
}
