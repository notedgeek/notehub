package com.notedgeek.notehub.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EditController {

    @GetMapping("/edit")
    public String getEdit() {
        return "edit";
    }
}
