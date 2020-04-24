package io.github.satya64.powerbi.api.services;

import io.github.satya64.powerbi.api.model.EmbedToken;
import io.github.satya64.powerbi.api.model.TokenRequest;
import io.github.satya64.powerbi.api.model.TokenRequestV2;
import retrofit2.Call;
import retrofit2.http.*;

public interface EmbedTokenService {
    @POST("groups/{groupId}/reports/{reportId}/GenerateToken")
    Call<EmbedToken> generateReportTokenInGroup(@Path("groupId") String groupId,
                                                @Path("reportId") String reportId,
                                                @Body TokenRequest request);

    @POST("groups/{groupId}/reports/GenerateToken")
    Call<EmbedToken> generateReportTokenForCreateInGroup(@Path("groupId") String groupId,
                                                         @Body TokenRequest request);


    @POST("GenerateToken")
    Call<EmbedToken> generateToken(@Body TokenRequestV2 request);

    @POST("groups/{groupId}/datasets/{datasetId}/GenerateToken")
    Call<EmbedToken> generateDatasetTokenInGroup(@Path("groupId") String groupId,
                                                 @Path("datasetId") String datasetId,
                                                 @Body TokenRequest request);

    @POST("groups/{groupId}/dashboards/{dashboardId}/GenerateToken")
    Call<EmbedToken> generateDashboardTokenInGroup(@Path("groupId") String groupId,
                                                   @Path("dashboardId") String dashboardId,
                                                   @Body TokenRequest request);

    @POST("groups/{groupId}/dashboards/{dashboardId}/tiles/{tileId}/GenerateToken")
    Call<EmbedToken> generateTileTokenInGroup(@Path("groupId") String groupId,
                                              @Path("dashboardId") String dashboardId,
                                              @Path("tileId") String tileId,
                                              @Body TokenRequest request);
}
