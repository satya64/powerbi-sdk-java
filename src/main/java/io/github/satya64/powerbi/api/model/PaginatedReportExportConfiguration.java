package io.github.satya64.powerbi.api.model;

import java.util.List;

public class PaginatedReportExportConfiguration {
    /* Dictionary of format settings. The keys are the device info property names for the requested file format. */
    private Object formatSettings;
    /* List of identities to use for RLS rules */
    private List<EffectiveIdentity> identities;
    /* List of report parameters */
    private List<ParameterValue> parameterValues;
}
