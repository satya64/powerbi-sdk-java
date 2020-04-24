package io.github.satya64.powerbi.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Datasource {

    /* The bound datasource id. Empty when not bound to a gateway. */
    private String datasourceId;

    /* (Deprecated) The datasource name. Available only for DirectQuery. */
    @Deprecated
    private String name;

    /* (Deprecated) The datasource connection string. Available only for DirectQuery. */
    @Deprecated
    private String connectionString;

    /* The datasource type */
    private String datasourceType;

    /* The bound gateway id. Empty when not bound to a gateway. */
    private String gatewayId;

    /* The datasource connection details */
    private DatasourceConnectionDetails connectionDetails;

}
