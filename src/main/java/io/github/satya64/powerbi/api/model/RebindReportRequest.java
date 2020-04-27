package io.github.satya64.powerbi.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RebindReportRequest {
    @NonNull
    private String datasetId;
}
