package io.github.satya64.powerbi.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Import {
    private String id;
    private String importState;
    private Instant createdDateTime;
    private Instant updatedDateTime;
    private String name;
}
