package io.github.satya64.powerbi.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tile {
    private String id;
    private String title;
    private int rowSpan;
    private int colSpan;
    private String embedData;
    private String embedUrl;
    private String datasetId;
    private String reportId;
}
