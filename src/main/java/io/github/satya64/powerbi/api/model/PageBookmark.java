package io.github.satya64.powerbi.api.model;

import lombok.Data;

@Data
public class PageBookmark {
    /* The bookmark name. Currently not supported */
    private String name;
    /* The bookmark state */
    private String state;

}
