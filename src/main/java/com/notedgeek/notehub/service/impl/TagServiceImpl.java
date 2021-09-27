package com.notedgeek.notehub.service.impl;

import com.notedgeek.notehub.entity.Tag;
import com.notedgeek.notehub.repository.TagRepository;
import com.notedgeek.notehub.service.TagService;
import org.springframework.stereotype.Service;

@Service
public class TagServiceImpl implements TagService {

    private final TagRepository repository;

    public TagServiceImpl(TagRepository repository) {
        this.repository = repository;
    }

    @Override
    public Tag ensureTag(String value) {
        value = value.toUpperCase();
        Tag result = repository.findTagByValue(value);
        if(result == null) {
            result = new Tag();
            result.setValue(value);
            repository.save(result);
        }
        return result;
    }
}
