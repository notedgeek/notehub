package com.notedgeek.notehub.controllers;

import com.notedgeek.notehub.asciidoctor.AsciidoctorConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

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
            //String markup = Files.readString(Paths.get(ClassLoader.getSystemResource("classpath:index.adoc").toURI()));
            try {
                File file = ResourceUtils.getFile("classpath:index.adoc");
                String markup = new String(Files.readAllBytes(file.toPath()));
                html = asciidoctor.convert(markup);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
