package com.notedgeek.notehub.util;

import com.notedgeek.notehub.entity.Tag;

import java.util.List;
import java.util.stream.Collectors;

public class Utils {

    public String getTagString(List<Tag> tags) {
        return tags.stream().map(Tag::getValue).collect(Collectors.joining(" "));
    }

}
