package io.github.satya64.powerbi.api.model;

import lombok.Data;

@Data
public class ExportReportPage {
    /* The bookmark to be applied on the page */
    private PageBookmark bookmark;
    /* The page name */
    private String pageName;
}
