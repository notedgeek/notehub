package com.notedgeek.notehub.controllers.html;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConvertController {

    @GetMapping("/convert")
    public String getEdit(Model model) {
        model.addAttribute("operation", "convert");
        return "edit";
    }
}
