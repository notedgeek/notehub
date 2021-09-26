package com.notedgeek.notehub.controllers.rest;

import com.notedgeek.notehub.entity.SimpleDoc;
import com.notedgeek.notehub.service.SimpleDocService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/list")
public class ListControllerRest {

    private final SimpleDocService service;

    public ListControllerRest(SimpleDocService service) {
        this.service = service;
    }

    @GetMapping
    public Iterable<SimpleDoc> listAll() {
        return service.listAll();
    }
}
