package io.github.satya64.powerbi.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class EffectiveIdentity {
    private String customData;
    private String[] datasets;
    private IdentityBlob identityBlob;
    private String[] reports;
    private String[] roles;
    private String username;
}
