package com.notedgeek.notehub.controllers.html;

import com.notedgeek.notehub.service.DocService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view")
public class ViewController {

    private final DocService service;

    public ViewController(DocService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public String list(@PathVariable long id, Model model) {
        model.addAttribute("doc", service.findById(id).orElse(null));
        return "view";
    }

}
