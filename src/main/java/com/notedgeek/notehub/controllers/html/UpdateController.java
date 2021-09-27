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
@RequestMapping("/update")
public class UpdateController {

    private final DocService docService;

    public UpdateController(DocService docService) {
        this.docService = docService;
    }

    @PostMapping
    public String update(@RequestParam long id, @RequestParam String markdown, @RequestParam String tags) {
        Doc doc = docService.findById(id).get();
        doc.setMarkdown(markdown);
        List<String> tagList = Arrays.asList(tags.split("[ ,]+"));
        docService.setTags(doc, tagList);
        docService.save(doc);
        return "redirect:/list";
    }

}
