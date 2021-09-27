package com.notedgeek.notehub.service.impl;

import com.notedgeek.notehub.entity.Doc;
import com.notedgeek.notehub.entity.Tag;
import com.notedgeek.notehub.entity.TagLink;
import com.notedgeek.notehub.repository.DocRepository;
import com.notedgeek.notehub.repository.TagLinkRepository;
import com.notedgeek.notehub.repository.TagRepository;
import com.notedgeek.notehub.service.DocService;
import com.notedgeek.notehub.util.AsciidoctorConverter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

@Service
public class DocServiceImpl implements DocService {

    private final DocRepository docRepository;
    private final TagRepository tagRepository;
    private final TagLinkRepository tagLinkRepository;
    private final AsciidoctorConverter converter;

    public DocServiceImpl(DocRepository docRepository, TagRepository tagRepository,
                          TagLinkRepository tagLinkRepository, AsciidoctorConverter converter) {
        this.docRepository = docRepository;
        this.tagRepository = tagRepository;
        this.tagLinkRepository = tagLinkRepository;
        this.converter = converter;
    }

    @Override
    public List<Doc> listAll() {
        List<Doc> docs = new ArrayList<>();
        docs.addAll(docRepository.findAll());
        docs.sort(Comparator.comparing(Doc::getDateUpdated).reversed());
        return docs;
    }

    @Override
    public Optional<Doc> findById(long id) {
        return docRepository.findById(id);
    }

    @Override
    public List<Doc> findByTagValues(List<String> tagValues) {
        List<Doc> docs = new ArrayList<>();
        boolean first = true;
        Set<Long> viableDocIds = null;
        for(String tagValue: tagValues) {
            Tag tag = ensureTag(tagValue);
            if(first) {
                viableDocIds = tagLinkRepository.findByTag(tag).stream()
                    .map(TagLink::getDoc).map(Doc::getId).collect(Collectors.toSet());
            } else {
                viableDocIds.retainAll(tagLinkRepository.findByTag(tag).stream()
                    .map(TagLink::getDoc).map(Doc::getId).collect(Collectors.toSet()));
            }
            if(viableDocIds.size() == 0) {
                return docs;
            }
            first = false;
        }
        for(long id: viableDocIds) {
            docs.add(docRepository.getById(id));
        }
        docs.sort(Comparator.comparing(Doc::getDateUpdated).reversed());
        return docs;
    }

    @Override
    public Doc save(Doc doc) {
        doc.setHtml(converter.convert(doc.getMarkdown()));
        Date date = new Date();
        doc.setDateUpdated(date);
        if(doc.getDateCreated() == null) {
            doc.setDateCreated(date);
        }
        return docRepository.save(doc);
    }

    @Override
    @Transactional
    public void setTags(Doc doc, Iterable<String> tagValues) {
        SortedSet<String> tagValueSet = new TreeSet<>();
        for(String tagValue: tagValues) {
            tagValueSet.add(tagValue);
        }
        List<TagLink> tagLinks = doc.getTagLinks();
        for(TagLink tagLink: tagLinks) {
            tagLinkRepository.delete(tagLink);
        }
        tagLinks.clear();
        for(String tagValue: tagValueSet) {
            Tag tag = ensureTag(tagValue);
            TagLink tagLink = new TagLink();
            tagLink.setDoc(doc);
            tagLink.setTag(tag);
            tagLinks.add(tagLink);
            tagLinkRepository.save(tagLink);
        }
    }

    @Override
    @Transactional
    public void addTag(Doc doc, String tagValue) {
        Tag tag = ensureTag(tagValue);
        TagLink tagLink = new TagLink();
        tagLink.setDoc(doc);
        tagLink.setTag(tag);
        doc.getTagLinks().add(tagLink);
    }

    private Tag ensureTag(String value) {
        value = value.toUpperCase();
        Tag result = tagRepository.findTagByValue(value);
        if(result == null) {
            result = new Tag();
            result.setValue(value);
            tagRepository.save(result);
        }
        return result;
    }

}
