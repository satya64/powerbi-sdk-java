package io.github.satya64.powerbi.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExportReportRequest {
    /* Export to file format */
    @NotNull
    private FileFormat format;
    /* The configuration used to export a paginated report */
    private PaginatedReportExportConfiguration paginatedReportConfiguration;
    /* The configuration used to export a Power BI report */
    private PowerBIReportExportConfiguration powerBIReportConfiguration;

}
