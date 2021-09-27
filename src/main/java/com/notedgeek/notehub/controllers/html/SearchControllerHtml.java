package com.notedgeek.notehub.controllers.html;

import com.notedgeek.notehub.service.DocService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/search")
public class SearchControllerHtml {

    private final DocService service;

    public SearchControllerHtml(DocService service) {
        this.service = service;
    }

    @GetMapping
    public String showSearchPage() {
        return "search";
    }

    @PostMapping
    public String doSearch(@RequestParam String tags, Model model) {
        List<String> tagList = Arrays.asList(tags.split("[ ,]+"));
        model.addAttribute("docs", service.findByTagValues(tagList));
        return "list";
    }

}
