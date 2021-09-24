package com.notedgeek.notehub.controllers;

import com.notedgeek.notehub.asciidoctor.AsciidoctorConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.nio.file.Files;
import java.nio.file.Paths;

@Controller
public class IndexController {

    private final AsciidoctorConverter asciidoctor = new AsciidoctorConverter();
    private String html = null;

    @GetMapping("/")
    public String index(Model model) {
        getHtml();
        model.addAttribute("html", html);
        return "index";
    }

    private synchronized void getHtml() {
        if(html == null) {
            try {
                String markup = Files.readString(Paths.get(ClassLoader.getSystemResource("index.adoc").toURI()));
                html = asciidoctor.convert(markup);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

}
