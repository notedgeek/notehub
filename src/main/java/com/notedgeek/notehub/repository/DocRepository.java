package com.notedgeek.notehub.repository;

import com.notedgeek.notehub.entity.Doc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocRepository extends JpaRepository<Doc, Long> {}
