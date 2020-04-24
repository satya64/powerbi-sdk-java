package io.github.satya64.powerbi.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Dataset {
    private String id;
    private String name;
    private String webUrl;
    private boolean addRowsAPIEnabled;
    private String configuredBy;
    private boolean isRefreshable;
    private boolean isEffectiveIdentityRequired;
    private boolean isEffectiveIdentityRolesRequired;
    private boolean isOnPremGatewayRequired;
}
