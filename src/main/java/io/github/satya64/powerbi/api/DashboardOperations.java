package io.github.satya64.powerbi.api;

import io.github.satya64.powerbi.api.model.*;
import io.github.satya64.powerbi.api.services.DashboardsService;
import io.github.satya64.powerbi.api.services.ReportsService;
import lombok.NonNull;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.List;

/**
 * Class to handle all report related operations
 */
public class DashboardOperations {

    private DashboardsService dashboardsService;

    public DashboardOperations(Retrofit retrofit) {
        this.dashboardsService = retrofit.create(DashboardsService.class);
    }

    /**
     * The method requires that below permissions enabled for the access token passed
     * - Content.Create
     *
     * @param addDashboardRequest AddDashboardRequest object
     * @return Dashboard
     * @throws IOException            This exception occurs in case any error with HTTP connection to powerbi REST API
     * @throws PowerBiClientException Wrapper exception class for converting powerbi errors to meaningful messages
     */
    public Dashboard addDashboard(@NonNull AddDashboardRequest addDashboardRequest) throws IOException, PowerBiClientException {
        Response<Dashboard> res = dashboardsService.addDashboard(addDashboardRequest).execute();
        return ClientUtils.buildAndSendResponseBody(res);
    }

    /**
     * The method requires that below permissions enabled for the access token passed
     * - Content.Create
     *
     * @param groupId             group id
     * @param addDashboardRequest AddDashboardRequest object
     * @return Dashboard
     * @throws IOException            This exception occurs in case any error with HTTP connection to powerbi REST API
     * @throws PowerBiClientException Wrapper exception class for converting powerbi errors to meaningful messages
     */
    public Dashboard addDashboardInGroup(@NonNull String groupId, @NonNull AddDashboardRequest addDashboardRequest) throws IOException, PowerBiClientException {
        Response<Dashboard> res = dashboardsService.addDashboardInGroup(groupId, addDashboardRequest).execute();
        return ClientUtils.buildAndSendResponseBody(res);
    }

    /**
     * The method requires that below permissions enabled for the access token passed
     * - Content.Create
     *
     * @param dashboardId dashboard id
     * @param tileId      tile id
     * @param cloneTileRequest CloneTileRequest
     * @return Dashboard
     * @throws IOException            This exception occurs in case any error with HTTP connection to powerbi REST API
     * @throws PowerBiClientException Wrapper exception class for converting powerbi errors to meaningful messages
     */
    public Tile cloneTile(@NonNull String dashboardId, @NonNull String tileId, @NonNull CloneTileRequest cloneTileRequest)
            throws IOException, PowerBiClientException {
        Response<Tile> res = dashboardsService.cloneTile(dashboardId, tileId, cloneTileRequest).execute();
        return ClientUtils.buildAndSendResponseBody(res);
    }

    /**
     * The method requires that below permissions enabled for the access token passed
     * - Content.Create
     *
     * @param groupId     group id
     * @param dashboardId dashboard id
     * @param tileId      tile id
     * @param cloneTileRequest CloneTileRequest
     * @return Tile
     * @throws IOException            This exception occurs in case any error with HTTP connection to powerbi REST API
     * @throws PowerBiClientException Wrapper exception class for converting powerbi errors to meaningful messages
     */
    public Tile cloneTileInGroup(@NonNull String groupId, @NonNull String dashboardId, @NonNull String tileId,
                                 @NonNull CloneTileRequest cloneTileRequest) throws IOException, PowerBiClientException {
        Response<Tile> res = dashboardsService.cloneTileInGroup(groupId, dashboardId, tileId, cloneTileRequest).execute();
        return ClientUtils.buildAndSendResponseBody(res);
    }

    /**
     * The method requires that below permissions enabled for the access token passed
     * - Dashboard.ReadWrite.All or Dashboard.Read.All
     *
     * @param dashboardId dashboard id
     * @return Dashboard
     * @throws IOException            This exception occurs in case any error with HTTP connection to powerbi REST API
     * @throws PowerBiClientException Wrapper exception class for converting powerbi errors to meaningful messages
     */
    public Dashboard getDashboard(@NonNull String dashboardId) throws IOException, PowerBiClientException {
        Response<Dashboard> res = dashboardsService.getDashboard(dashboardId).execute();
        return ClientUtils.buildAndSendResponseBody(res);
    }

    /**
     * The method requires that below permissions enabled for the access token passed
     * - Dashboard.ReadWrite.All or Dashboard.Read.All
     *
     * @param groupId  group id
     * @param dashboardId dashboard id
     * @return Dashboard
     * @throws IOException            This exception occurs in case any error with HTTP connection to powerbi REST API
     * @throws PowerBiClientException Wrapper exception class for converting powerbi errors to meaningful messages
     */
    public Dashboard getDashboardInGroup(@NonNull String groupId, @NonNull String dashboardId) throws IOException, PowerBiClientException {
        Response<Dashboard> res = dashboardsService.getDashboardInGroup(groupId, dashboardId).execute();
        return ClientUtils.buildAndSendResponseBody(res);
    }

    /**
     * The method requires that below permissions enabled for the access token passed
     * - Dashboard.ReadWrite.All or Dashboard.Read.All
     *
     * @return {@code ODataResponse<List<Dashboard>>}
     * @throws IOException            This exception occurs in case any error with HTTP connection to powerbi REST API
     * @throws PowerBiClientException Wrapper exception class for converting powerbi errors to meaningful messages
     */
    public ODataResponse<List<Dashboard>> getDashboards() throws IOException, PowerBiClientException {
        Response<ODataResponse<List<Dashboard>>> res = dashboardsService.getDashboards().execute();
        return ClientUtils.buildAndSendResponseBody(res);
    }

    /**
     * The method requires that below permissions enabled for the access token passed
     * - Dashboard.ReadWrite.All or Dashboard.Read.All
     *
     * @param groupId group id
     * @return {@code ODataResponse<List<Dashboard>>}
     * @throws IOException            This exception occurs in case any error with HTTP connection to powerbi REST API
     * @throws PowerBiClientException Wrapper exception class for converting powerbi errors to meaningful messages
     */
    public ODataResponse<List<Dashboard>> getDashboardsInGroup(@NonNull String groupId) throws IOException, PowerBiClientException {
        Response<ODataResponse<List<Dashboard>>> res = dashboardsService.getDashboardsInGroup(groupId).execute();
        return ClientUtils.buildAndSendResponseBody(res);
    }

    /**
     * The method requires that below permissions enabled for the access token passed
     * - Dashboard.ReadWrite.All or Dashboard.Read.All
     *
     * @param dashboardId dashboard id
     * @param tileId tile id
     * @return Tile
     * @throws IOException            This exception occurs in case any error with HTTP connection to powerbi REST API
     * @throws PowerBiClientException Wrapper exception class for converting powerbi errors to meaningful messages
     */
    public Tile getTile(@NonNull String dashboardId, @NonNull String tileId) throws IOException, PowerBiClientException {
        Response<Tile> res = dashboardsService.getTile(dashboardId, tileId).execute();
        return ClientUtils.buildAndSendResponseBody(res);
    }

    /**
     * The method requires that below permissions enabled for the access token passed
     * - Dashboard.ReadWrite.All or Dashboard.Read.All
     *
     * @param groupId  group id
     * @param dashboardId dashboard id
     * @param tileId tile id
     * @return Tile
     * @throws IOException            This exception occurs in case any error with HTTP connection to powerbi REST API
     * @throws PowerBiClientException Wrapper exception class for converting powerbi errors to meaningful messages
     */
    public Tile getTileInGroup(@NonNull String groupId, @NonNull String dashboardId, @NonNull String tileId) throws IOException, PowerBiClientException {
        Response<Tile> res = dashboardsService.getTileInGroup(groupId, dashboardId, tileId).execute();
        return ClientUtils.buildAndSendResponseBody(res);
    }

    /**
     * The method requires that below permissions enabled for the access token passed
     * - Dashboard.ReadWrite.All or Dashboard.Read.All
     *
     * @param dashboardId dashboard id
     * @return {@code ODataResponse<List<Tile>>}
     * @throws IOException            This exception occurs in case any error with HTTP connection to powerbi REST API
     * @throws PowerBiClientException Wrapper exception class for converting powerbi errors to meaningful messages
     */
    public ODataResponse<List<Tile>> getTiles(@NonNull String dashboardId) throws IOException, PowerBiClientException {
        Response<ODataResponse<List<Tile>>> res = dashboardsService.getTiles(dashboardId).execute();
        return ClientUtils.buildAndSendResponseBody(res);
    }

    /**
     * The method requires that below permissions enabled for the access token passed
     * - Dashboard.ReadWrite.All or Dashboard.Read.All
     *
     * @param groupId group id
     * @param dashboardId dashboard id
     * @return {@code ODataResponse<List<Tile>>}
     * @throws IOException            This exception occurs in case any error with HTTP connection to powerbi REST API
     * @throws PowerBiClientException Wrapper exception class for converting powerbi errors to meaningful messages
     */
    public ODataResponse<List<Tile>> getTilesInGroup(@NonNull String groupId, @NonNull String dashboardId) throws IOException, PowerBiClientException {
        Response<ODataResponse<List<Tile>>> res = dashboardsService.getTilesInGroup(groupId, dashboardId).execute();
        return ClientUtils.buildAndSendResponseBody(res);
    }

}
