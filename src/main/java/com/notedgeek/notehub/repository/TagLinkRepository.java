package com.notedgeek.notehub.repository;

import com.notedgeek.notehub.entity.Tag;
import com.notedgeek.notehub.entity.TagLink;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagLinkRepository extends JpaRepository<TagLink, Long> {

    List<TagLink> findByTag(Tag tag);

}
