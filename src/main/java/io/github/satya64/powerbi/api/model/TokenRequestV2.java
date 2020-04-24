package io.github.satya64.powerbi.api.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class TokenRequestV2 {

    private List<EffectiveIdentity> identities;

    private List<TokenRequestDataset> datasets;

    private List<TokenRequestReport> reports;

    private List<TokenRequestTargetWorkspace> targetWorkspaces;
}
