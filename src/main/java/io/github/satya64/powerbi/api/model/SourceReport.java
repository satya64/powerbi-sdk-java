package io.github.satya64.powerbi.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SourceReport {
    private String sourceReportId;
    private String sourceWorkspaceId;
}
