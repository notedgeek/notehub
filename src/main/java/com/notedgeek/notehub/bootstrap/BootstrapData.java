package com.notedgeek.notehub.bootstrap;

import com.notedgeek.notehub.entity.Doc;
import com.notedgeek.notehub.service.DocService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.stream.Stream;

//@Component
public class BootstrapData implements CommandLineRunner {

    private final DocService service;

    public BootstrapData(DocService service) {
        this.service = service;
    }

    @Override
    public void run(String... args) throws Exception {

        Stream.of(new File("src/main/resources/bootstrapData").listFiles())
            .filter(file -> file.getName().endsWith(".adoc"))
            .map(File::getPath)
            .sorted()
            .forEach(filename -> loadDoc(filename));

    }

    private void loadDoc(String filename) {
        try(InputStream inputStream = new FileInputStream(filename)) {
            byte[] bytes = FileCopyUtils.copyToByteArray(inputStream);
            String markdown =  new String(bytes, StandardCharsets.UTF_8);
            Doc doc = new Doc();
            doc.setMarkdown(markdown);
            service.save(doc);
        } catch (IOException ioex) {
            throw new RuntimeException(ioex);
        }
    }
}
