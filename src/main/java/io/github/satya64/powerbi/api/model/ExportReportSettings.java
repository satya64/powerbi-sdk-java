package io.github.satya64.powerbi.api.model;

import lombok.Data;

@Data
public class ExportReportSettings {
    private boolean includeHiddenPages;
    private String locale;

}
