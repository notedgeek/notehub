package com.notedgeek.notehub.util;

import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.client.ResourceAccessException;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Component
public class ResourceHelper {

    private final ResourceLoader resourceLoader;

    public ResourceHelper(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public String getFileAsString(String filename) {
        try(InputStream inputStream = resourceLoader.getResource("classpath:" + filename).getInputStream()) {
            byte[] bytes = FileCopyUtils.copyToByteArray(inputStream);
            return new String(bytes, StandardCharsets.UTF_8);
        } catch (IOException ioex) {
            throw new ResourceAccessException(ioex.getMessage());
        }
    }

}
