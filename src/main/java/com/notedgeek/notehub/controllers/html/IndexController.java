package com.notedgeek.notehub.controllers.html;

import com.notedgeek.notehub.util.AsciidoctorConverter;
import com.notedgeek.notehub.util.ResourceHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    private final AsciidoctorConverter asciidoctor = new AsciidoctorConverter();
    private String html = null;
    private final ResourceHelper resourceHelper;

    public IndexController(ResourceHelper resourceHelper) {
        this.resourceHelper = resourceHelper;
    }

    @GetMapping("/")
    public String index(Model model) {
        getHtml();
        model.addAttribute("html", html);
        return "index";
    }

    private synchronized void getHtml() {
        if(html == null) {
            String markup = resourceHelper.getFileAsString("index.adoc");
            html = asciidoctor.convert(markup);
        }
    }
}
