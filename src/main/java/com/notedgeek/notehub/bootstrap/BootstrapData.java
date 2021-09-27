package com.notedgeek.notehub.bootstrap;

import com.notedgeek.notehub.entity.Doc;
import com.notedgeek.notehub.service.DocService;
import com.notedgeek.notehub.service.TagService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Component
public class BootstrapData implements CommandLineRunner {

    private final DocService docService;
    private final TagService tagService;

    public BootstrapData(DocService docService, TagService tagService) {
        this.docService = docService;
        this.tagService = tagService;
    }

    @Override
    @Transactional
    public void run(String... args) {

//        Stream.of(new File("src/main/resources/bootstrapData").listFiles())
//            .filter(file -> file.getName().endsWith(".adoc"))
//            .map(File::getPath)
//            .sorted()
//            .forEach(filename -> loadDoc(filename));

//         Doc doc = docService.findById(1).get();
//         docService.addTag(doc, "monkey");
//         docService.addTag(doc, "monkey");
//         docService.addTag(doc, "ape");

    }

    private void loadDoc(String filename) {
        try(InputStream inputStream = new FileInputStream(filename)) {
            byte[] bytes = FileCopyUtils.copyToByteArray(inputStream);
            String markdown =  new String(bytes, StandardCharsets.UTF_8);
            Doc doc = new Doc();
            doc.setMarkdown(markdown);
            docService.save(doc);
        } catch (IOException ioex) {
            throw new RuntimeException(ioex);
        }
    }
}
