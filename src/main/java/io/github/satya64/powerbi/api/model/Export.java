package io.github.satya64.powerbi.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Export {
    private String id;
    private String reportId;
    private String reportName;
    private String resourceLocation;
    private Integer percentComplete;
    private String lastActionDateTime;
    private String expirationTime;
    private String createdDateTime;
    private ExportState status;
}
