package io.github.satya64.powerbi.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NonNull;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GroupUser {
    /**
     * Display name of the principal
     */
    private String displayName;
    /**
     * Email address of the user
     */
    private String emailAddress;
    /**
     * Access rights user has for the workspace
     */
    @NonNull
    private GroupUserAccessRight groupUserAccessRight;
    /**
     * Identifier of the principal
     */
    private String identifier;
    /**
     * The principal type
     */
    private PrincipalType principalType;

}
