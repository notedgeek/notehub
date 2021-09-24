package com.notedgeek.notehub.asciidoctor;

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

    private static final String DEFAULT_ASCIIDOC = // "//EDIT TEXT AND/OR CLICK ON THE RENDER BUTTON TO RENDER THIS SNIPPET\n" +
        "= HEADING 1\n" +
            "\n" +
            "== Heading 2\n" +
            "=== heading 3\n" +
            "==== heading 4\n" +
            "{doctitle} This is just\n" +
            "some text.\n" +
            "\n" +
            "This is another paragraph,\n" +
            "with some `code`,  *bold*, and _italic_ text.\n" +
            "[source, java]\n" +
            "----\n" +
            "@RequestMapping(\"convert\")\n" +
            "public String convert(\n" +
            "    @RequestParam(name = \"asciidoc\", defaultValue = DEFAULT_ASCIIDOC) String asciidoc, \n" +
            "    Model model\n" +
            ") {\n" +
            "    String html = AsciidoctorConverter.convert(asciidoc);\n" +
            "    model.addAttribute(\"html\", html);\n" +
            "    return \"render\";\n" +
            "}\n" +
            "----\n"
//        "= creating collections\n" +
//        "\n" +
//        "[source, kotlin]\n" +
//        "----\n" +
//        "val set = hashSetOf(1, 7, 53)\n" +
//        "\n" +
//        "val list = arrayListOf(1, 7, 53)\n" +
//        "\n" +
//        "val map = hashMapOf(1 to \"one\", 7 to \"seven\", 53 to \"fifty-three\")\n" +
//        "----\n" +
//        "\n" +
//        "[source, kotlin]\n" +
//        "----\n" +
//        "val strings = listOf(\"first\", \"second\", \"fourteenth\")\n" +
//        "\n" +
//        "println(strings.javaClass)\n" +
//        "\n" +
//        "println(strings.last())\n" +
//        "\n" +
//        "// => class java.util.Arrays$ArrayList\n" +
//        "// => fourteenth\n" +
//        "----\n" +
//        "\n" +
//        "[source, kotlin]\n" +
//        "----\n" +
//        "val numbers = setOf(1, 14, 2)\n" +
//        "\n" +
//        "println(numbers.javaClass)\n" +
//        "\n" +
//        "println(numbers.max())\n" +
//        "\n" +
//        "// => class java.util.LinkedHashSet\n" +
//        "// => 14\n" +
//        "----"
        ;

    public static void main(String[] args) {
        String source = DEFAULT_ASCIIDOC;
        AsciidoctorConverter converter = new AsciidoctorConverter();
        System.out.println(converter.convert(source));
        System.out.println(converter.convert(source));
        System.out.println(converter.convert(source));
        System.out.println(converter.convert(source));
    }
}
