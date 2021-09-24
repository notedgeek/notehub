package com.notedgeek.notehub.controllers;

import com.notedgeek.notehub.asciidoctor.AsciidoctorConverter;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Controller
public class IndexController {

    private final AsciidoctorConverter asciidoctor = new AsciidoctorConverter();
    private String html = null;
    private final ResourceLoader resourceLoader;

    public IndexController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @GetMapping("/")
    public String index(Model model) {
        getHtml();
        model.addAttribute("html", html);
        return "index";
    }

    private synchronized void getHtml() {
        if(html == null) {
            try {
                Resource resource = resourceLoader.getResource("classpath:index.adoc");
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
