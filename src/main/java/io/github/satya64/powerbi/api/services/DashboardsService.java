package io.github.satya64.powerbi.api.services;

import io.github.satya64.powerbi.api.model.*;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface DashboardsService {

    @POST("dashboards")
    Call<Dashboard> addDashboard(@Body AddDashboardRequest addDashboardRequest);

    @POST("groups/{groupId}/dashboards")
    Call<Dashboard> addDashboardInGroup(@Path("groupId") String groupId, @Body AddDashboardRequest addDashboardRequest);

    @POST("dashboards/{dashboardId}/tiles/{tileId}/Clone")
    Call<Tile> cloneTile(@Path("dashboardId") String dashboardId, @Path("tileId") String tileId,
                         @Body CloneTileRequest cloneTileRequest);

    @POST("groups/{groupId}/dashboards/{dashboardId}/tiles/{tileId}/Clone")
    Call<Tile> cloneTileInGroup(@Path("groupId") String groupId,@Path("dashboardId") String dashboardId,
                                @Path("tileId") String tileId, @Body CloneTileRequest cloneTileRequest);

    @GET("dashboards")
    Call<ODataResponse<List<Dashboard>>> getDashboards();

    @GET("groups/{groupId}/dashboards")
    Call<ODataResponse<List<Dashboard>>> getDashboardsInGroup(@Path("groupId") String groupId);

    @GET("dashboards/{dashboardId}")
    Call<Dashboard> getDashboard(@Path("dashboardId") String dashboardId);

    @GET("groups/{groupId}/dashboards/{dashboardId}")
    Call<Dashboard> getDashboardInGroup(@Path("groupId") String groupId, @Path("dashboardId") String dashboardId);

    @GET("dashboards/{dashboardId}/tiles/{tileId}")
    Call<Tile> getTile(@Path("dashboardId") String dashboardId, @Path("tileId") String tileId);

    @GET("groups/{groupId}/dashboards/{dashboardId}/tiles/{tileId}")
    Call<Tile> getTileInGroup(@Path("groupId") String groupId,@Path("dashboardId") String dashboardId,
                                @Path("tileId") String tileId);

    @GET("dashboards/{dashboardId}/tiles")
    Call<ODataResponse<List<Tile>>> getTiles(@Path("dashboardId") String dashboardId);

    @GET("groups/{groupId}/dashboards/{dashboardId}/tiles")
    Call<ODataResponse<List<Tile>>> getTilesInGroup(@Path("groupId") String groupId,@Path("dashboardId") String dashboardId);

}
