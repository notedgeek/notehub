package com.notedgeek.notehub.bootstrap;

import com.notedgeek.notehub.entity.SimpleDoc;
import com.notedgeek.notehub.service.SimpleDocService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final SimpleDocService simpleDocService;

    public BootstrapData(SimpleDocService simpleDocService) {
        this.simpleDocService = simpleDocService;
    }

    @Override
    public void run(String... args) throws Exception {
        SimpleDoc simpleDoc = new SimpleDoc();
        simpleDoc.setMarkup("= Title1\n some text");
        simpleDocService.save(simpleDoc);
        simpleDoc = new SimpleDoc();
        simpleDoc.setMarkup("= Title2\n some more text");
        simpleDocService.save(simpleDoc);

    }
}
