package io.github.satya64.powerbi.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Dashboard {
    private String id;
    private String displayName;
    private String embedUrl;
    private boolean isReadOnly;
    private Tile[] tiles;
}
