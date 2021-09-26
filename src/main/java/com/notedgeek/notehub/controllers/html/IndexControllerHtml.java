package com.notedgeek.notehub.controllers.html;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexControllerHtml {

    @GetMapping
    public String index() {
        return "redirect:/list";
    }

}
