package com.notedgeek.notehub.controllers.rest;

import com.notedgeek.notehub.dto.DocDto;
import com.notedgeek.notehub.entity.Doc;
import com.notedgeek.notehub.service.DocService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/list")
public class ListControllerRest {

    private final DocService service;

    public ListControllerRest(DocService service) {
        this.service = service;
    }

    @GetMapping
    public List<DocDto> listAll(HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        return service.listAll().stream().map(DocDto::fromEntity).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Doc getById(@PathVariable long id) {
        return service.findById(id).orElse(null);
    }
}
