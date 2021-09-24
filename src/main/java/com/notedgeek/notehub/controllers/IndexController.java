package com.notedgeek.notehub.controllers;

import com.notedgeek.notehub.asciidoctor.AsciidoctorConverter;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
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
            //String markup = Files.readString(Paths.get(ClassLoader.getSystemResource("classpath:index.adoc").toURI()));
            try {
                Resource resource = new ClassPathResource("classpath:index.adoc");
                InputStream inputStream = resource.getInputStream();
                byte[] bytes = FileCopyUtils.copyToByteArray(inputStream);
                String markup = new String(bytes, StandardCharsets.UTF_8);
                html = asciidoctor.convert(markup);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
