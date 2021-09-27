package com.notedgeek.notehub.util;

import com.notedgeek.notehub.entity.TagLink;

import java.util.List;
import java.util.stream.Collectors;

public class Utils {

    public String getTagString(List<TagLink> tagLinks) {
        return tagLinks.stream().map(tl -> tl.getTag().getValue()).collect(Collectors.joining(" "));
    }

}
