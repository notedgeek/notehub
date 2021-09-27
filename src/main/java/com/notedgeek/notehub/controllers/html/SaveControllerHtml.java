package com.notedgeek.notehub.controllers.html;

import com.notedgeek.notehub.entity.Doc;
import com.notedgeek.notehub.service.DocService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/save")
public class SaveControllerHtml {

    private final DocService docService;

    public SaveControllerHtml(DocService docService) {
        this.docService = docService;
    }

    @PostMapping
    public String save(@RequestParam String markdown, @RequestParam String tags) {
        Doc doc = new Doc();
        doc.setMarkdown(markdown);
        doc = docService.save(doc);
        List<String> tagList = Arrays.asList(tags.trim().split("[ ,]+"));
        docService.setTags(doc, tagList);
        docService.save(doc);
        return "redirect:/list";
    }
}
