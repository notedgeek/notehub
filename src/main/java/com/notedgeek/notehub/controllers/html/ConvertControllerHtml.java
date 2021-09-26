package com.notedgeek.notehub.controllers.html;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/convert")
public class ConvertControllerHtml {

    @GetMapping
    public String getEdit(Model model) {
        return "convert";
    }
}
