package com.notedgeek.notehub.controllers.rest;

import com.notedgeek.notehub.util.AsciidoctorConverter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConvertController {

    private final AsciidoctorConverter converter;

    public ConvertController(AsciidoctorConverter converter) {
        this.converter = converter;
    }

    @PostMapping("/convert")
    public String convert(@RequestBody String adoc) {
        return converter.convert(adoc);
    }
}
