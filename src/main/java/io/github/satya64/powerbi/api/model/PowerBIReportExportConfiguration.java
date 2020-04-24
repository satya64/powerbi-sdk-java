package io.github.satya64.powerbi.api.model;

import java.util.List;

public class PowerBIReportExportConfiguration {
    /*
    defaultBookmark
PageBookmark
The default bookmark to apply on all pages which don't have a specific bookmark

identities
EffectiveIdentity[]
List of identities to use for RLS rules

pages
ExportReportPage[]
List of pages to export and their properties

settings
ExportReportSettings
The settings to be applied in this Export to file job
     */
    /* The default bookmark to apply on all pages which don't have a specific bookmark */
    private PageBookmark defaultBookmark;
    /* List of identities to use for RLS rules */
    private List<EffectiveIdentity> identities;
    /* List of pages to export and their properties */
    private List<ExportReportPage> pages;
    /* The settings to be applied in this Export to file job */
    private ExportReportSettings settings;
}
