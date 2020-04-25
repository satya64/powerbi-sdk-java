package io.github.satya64.powerbi.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NonNull;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GroupUser {
    private String displayName;
    private String emailAddress;
    @NonNull
    private GroupUserAccessRight groupUserAccessRight;
    private String identifier;
    private PrincipalType principalType;

}
