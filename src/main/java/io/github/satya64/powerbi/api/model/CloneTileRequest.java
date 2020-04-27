package io.github.satya64.powerbi.api.model;

import lombok.NonNull;

public class CloneTileRequest {
    /**
     * Optional parameter for specifying the action in case of position conflict.
     * If not provided, 'Tail' is used.
     * If there is no conflict, clone tile to same position as in source.
     */
    private PositionConflictAction positionConflictAction;
    @NonNull
    private String targetDashboardId;
    /**
     * Optional parameter
     * When cloning a tile linked to a dataset, pass the target model id to rebind the new tile to a different dataset.
     */
    private String targetModelId;
    /**
     * Optional parameter
     * When cloning a tile linked to a report, pass the target report id to rebind the new tile to a different report.
     */
    private String targetReportId;
    /**
     * Optional parameter for specifying the target workspace id. Empty Guid (00000000-0000-0000-0000-000000000000) indicates 'My Workspace'.
     * If not provided, tile will be cloned within the same workspace as the source tile.
     */
    private String targetWorkspaceId;
}
