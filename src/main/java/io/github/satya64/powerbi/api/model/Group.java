package io.github.satya64.powerbi.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Group {
    private String id;
    private boolean isReadOnly;
    private boolean isOnDedicatedCapacity;
    private String capacityId;
    private String name;
}
