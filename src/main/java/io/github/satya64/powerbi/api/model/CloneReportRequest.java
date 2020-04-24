package io.github.satya64.powerbi.api.model;

import lombok.Data;
import lombok.NonNull;

@Data
public class CloneReportRequest {
    @NonNull
    private String name;
    private String targetModelId;
    private String targetWorkspaceId;
}
