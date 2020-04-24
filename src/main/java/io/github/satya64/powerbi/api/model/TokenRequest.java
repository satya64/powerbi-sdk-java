package io.github.satya64.powerbi.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class TokenRequest {

    private AccessLevel accessLevel;

    private List<EffectiveIdentity> identities;

    @JsonProperty(defaultValue = "false")
    private boolean allowSaveAs;

    private String datasetId;

}
