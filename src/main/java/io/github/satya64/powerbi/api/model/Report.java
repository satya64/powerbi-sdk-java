package io.github.satya64.powerbi.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class Report extends ODataEntity{
    private String id;
    private String reportType;
    private String name;
    private String webUrl;
    private String embedUrl;
    private boolean isFromPbix;
    private boolean isOwnedByMe;
    private String datasetId;
}
