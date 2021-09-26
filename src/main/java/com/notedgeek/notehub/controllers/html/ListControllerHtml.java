package com.notedgeek.notehub.controllers.html;

import com.notedgeek.notehub.entity.Doc;
import com.notedgeek.notehub.service.DocService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{id}")
    public String list(@PathVariable long id, Model model) {
        List<Doc> results = new ArrayList<>();
        Optional<Doc> doc = service.findById(id);
        if(doc.isPresent()) {
            results.add(doc.get());
        }
        model.addAttribute("docs", results);
        return "list";
    }

}
