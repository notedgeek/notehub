package com.notedgeek.notehub.controllers.html;

import com.notedgeek.notehub.entity.Doc;
import com.notedgeek.notehub.service.DocService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/save")
public class SaveControllerHtml {

    final DocService docService;

    public SaveControllerHtml(DocService docService) {
        this.docService = docService;
    }

    @PostMapping
    public String save(@RequestParam String markdown) {
        Doc doc = new Doc();
        doc.setMarkdown(markdown);
        docService.save(doc);
        return "redirect:/list";
    }
}
