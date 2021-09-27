package com.notedgeek.notehub.controllers.html;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/search")
public class SearchControllerHtml {

    @GetMapping
    public String showSearchPage() {
        return "search";
    }

    @PostMapping
    public String doSearch(@RequestParam String tags) {
        return "list";
    }

}
