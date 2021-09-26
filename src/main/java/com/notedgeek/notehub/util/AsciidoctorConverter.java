package com.notedgeek.notehub.util;

import org.asciidoctor.Asciidoctor;
import org.asciidoctor.Attributes;
import org.asciidoctor.Options;
import org.springframework.stereotype.Component;

@Component
public class AsciidoctorConverter {

    private final Asciidoctor asciidoctor = Asciidoctor.Factory.create();

    public synchronized String convert(String input) {
        Attributes attributes = Attributes.builder().sourceHighlighter("rouge").showTitle(true).build();
        attributes.setAttribute("leveloffset", "1");
        return asciidoctor.convert(input, Options.builder().attributes(attributes).build());
    }

}
