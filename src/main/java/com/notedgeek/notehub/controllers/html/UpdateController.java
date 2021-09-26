package com.notedgeek.notehub.controllers.html;

import com.notedgeek.notehub.entity.Doc;
import com.notedgeek.notehub.service.DocService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/update")
public class UpdateController {

    private final DocService service;

    public UpdateController(DocService service) {
        this.service = service;
    }

    @PostMapping
    public String update(@RequestParam long id, @RequestParam String markdown) {
        Doc doc = service.findById(id).get();
        doc.setMarkdown(markdown);
        service.save(doc);
        return "redirect:/list";
    }

}
