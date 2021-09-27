package com.notedgeek.notehub.repository;

import com.notedgeek.notehub.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {

    Tag findTagByValue(String value);

}
