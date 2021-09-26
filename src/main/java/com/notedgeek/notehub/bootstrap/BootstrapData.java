package com.notedgeek.notehub.bootstrap;

import com.notedgeek.notehub.entity.SimpleDoc;
import com.notedgeek.notehub.service.SimpleDocService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.client.ResourceAccessException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.stream.Stream;

@Component
public class BootstrapData implements CommandLineRunner {

    private final SimpleDocService service;

    public BootstrapData(SimpleDocService service) {
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
            SimpleDoc simpleDoc = new SimpleDoc();
            simpleDoc.setMarkdown(markdown);
            service.save(simpleDoc);
        } catch (IOException ioex) {
            throw new ResourceAccessException(ioex.getMessage());
        }

    }
}
