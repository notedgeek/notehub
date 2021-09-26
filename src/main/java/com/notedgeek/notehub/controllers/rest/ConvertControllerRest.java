package com.notedgeek.notehub.controllers.rest;

import com.notedgeek.notehub.util.AsciidoctorConverter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/convert")
public class ConvertControllerRest {

    private final AsciidoctorConverter converter;

    public ConvertControllerRest(AsciidoctorConverter converter) {
        this.converter = converter;
    }

    @PostMapping()
    public String convert(@RequestBody String adoc) {
        return converter.convert(adoc);
    }
}
