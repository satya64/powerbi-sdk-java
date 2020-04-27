package io.github.satya64.powerbi.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateReportContentRequest {
    @NonNull
    private SourceReport sourceReport;

    @NonNull
    private SourceType sourceType;
}
