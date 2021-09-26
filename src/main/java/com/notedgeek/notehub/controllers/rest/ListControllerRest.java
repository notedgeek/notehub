package com.notedgeek.notehub.controllers.rest;

import com.notedgeek.notehub.entity.Doc;
import com.notedgeek.notehub.service.DocService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/list")
public class ListControllerRest {

    private final DocService service;

    public ListControllerRest(DocService service) {
        this.service = service;
    }

    @GetMapping
    public Iterable<Doc> listAll() {
        return service.listAll();
    }
}
