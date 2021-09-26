package com.notedgeek.notehub.controllers.html;

import com.notedgeek.notehub.entity.Doc;
import com.notedgeek.notehub.service.DocService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/edit")
public class EditController {

    private final DocService service;

    public EditController(DocService service) {
        this.service = service;
    }

    @GetMapping
    @RequestMapping("{id}")
    public String edit (@PathVariable long id, Model model) {
        Doc doc = service.findById(id).get();
        model.addAttribute("doc", doc);
        return "edit";
    }
}
