package io.github.satya64.powerbi.api.model;

import lombok.Data;
import lombok.NonNull;

@Data
public class ExportReportRequest {
    /* Export to file format */
    @NonNull
    private FileFormat format;
    /* The configuration used to export a paginated report */
    private PaginatedReportExportConfiguration paginatedReportConfiguration;
    /* The configuration used to export a Power BI report */
    private PowerBIReportExportConfiguration powerBIReportConfiguration;

}
