package com.notedgeek.notehub.controllers.html;

import com.notedgeek.notehub.service.DocService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/list")
public class ListControllerHtml {

    private final DocService service;

    public ListControllerHtml(DocService service) {
        this.service = service;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("docs", service.listAll());
        return "list";
    }

}
