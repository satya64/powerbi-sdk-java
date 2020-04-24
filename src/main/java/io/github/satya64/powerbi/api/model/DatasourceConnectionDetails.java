package io.github.satya64.powerbi.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DatasourceConnectionDetails {
    /* The connection database */
    private String database;
    /* The connection server */
    private String server;
    /* The connection url */
    private String url;
}
