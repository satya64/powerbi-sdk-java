package io.github.satya64.powerbi.api.services;

import io.github.satya64.powerbi.api.model.*;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

import javax.validation.Valid;
import java.util.List;

public interface ReportsService {
    @GET("reports")
    Call<ODataResponse<List<Report>>> getReports();

    @GET("groups/{groupId}/reports")
    Call<ODataResponse<List<Report>>> getReportsInGroup(@Path("groupId") String groupId);

    @GET("reports/{reportId}")
    Call<Report> getReport(@Path("reportId") String reportId);

    @GET("groups/{groupId}/reports/{reportId}")
    Call<Report> getReportInGroup(@Path("groupId") String groupId, @Path("reportId") String reportId);

    @POST("reports/{reportId}/Clone")
    Call<Report> cloneReport(@Path("reportId") String reportId, @Body CloneReportRequest request);

    @POST("groups/{groupId}/reports/{reportId}/Clone")
    Call<Report> cloneReportInGroup(@Path("groupId") String groupId, @Path("reportId") String reportId,
                                    @Body CloneReportRequest request);

    @POST("reports/{reportId}/Export")
    Call<ResponseBody> exportReport(@Path("reportId") String reportId);

    @POST("groups/{groupId}/reports/{reportId}/Export")
    Call<ResponseBody> exportReportInGroup(@Path("groupId") String groupId, @Path("reportId") String reportId);

    @GET("reports/{reportId}/datasources")
    Call<ODataResponse<List<Datasource>>> getReportDatasources(@Path("reportId") String reportId);

    @GET("groups/{groupId}/reports/{reportId}/datasources")
    Call<ODataResponse<List<Datasource>>> getReportDatasourcesInGroup(@Path("groupId") String groupId,
                                                                      @Path("reportId") String reportId);

    @DELETE("reports/{reportId}")
    Call<Void> deleteReport(@Path("reportId") String reportId);

    @DELETE("groups/{groupId}/reports/{reportId}")
    Call<Void> deleteReportInGroup(@Path("groupId") String groupId, @Path("reportId") String reportId);

    @POST("reports/{reportId}/ExportTo")
    Call<Export> exportReportToFile(@Path("reportId") String reportId, @Valid @Body ExportReportRequest request);

    @POST("groups/{groupId}/reports/{reportId}/ExportTo")
    Call<Export> exportReportInGroupToFile(@Path("groupId") String groupId, @Path("reportId") String reportId,
                                           @Valid @Body ExportReportRequest request);

    @GET("reports/{reportId}/exports/{exportId}")
    Call<Export> getExportToFileStatus(@Path("reportId") String reportId, @Path("exportId") String exportId);

    @GET("groups/{groupId}/reports/{reportId}/exports/{exportId}")
    Call<Export> getExportToFileStatusInGroup(@Path("groupId") String groupId, @Path("reportId") String reportId,
                                              @Path("exportId") String exportId);

    @GET("reports/{reportId}/exports/{exportId}/file")
    Call<ResponseBody> getFileOfExportToFile(@Path("reportId") String reportId, @Path("exportId") String exportId);

    @GET("groups/{groupId}/reports/{reportId}/exports/{exportId}/file")
    Call<ResponseBody> getFileOfExportToFileInGroup(@Path("groupId") String groupId, @Path("reportId") String reportId,
                                                    @Path("exportId") String exportId);

    @GET("reports/{reportId}/pages/{pageName}")
    Call<Page> getPage(@Path("reportId") String reportId, @Path("reportId") String pageName);

    @GET("groups/{groupId}/reports/{reportId}/pages/{pageName}")
    Call<Page> getPageInGroup(@Path("groupId") String groupId, @Path("reportId") String reportId,
                              @Path("reportId") String pageName);

    @GET("reports/{reportId}/pages")
    Call<ODataResponse<List<Page>>> getPages(@Path("reportId") String reportId);

    @GET("groups/{groupId}/reports/{reportId}/pages")
    Call<ODataResponse<List<Page>>> getPagesInGroup(@Path("groupId") String groupId, @Path("reportId") String reportId);

    @POST("reports/{reportId}/Rebind")
    Call<Void> rebindReport(@Path("reportId") String reportId, @Body RebindReportRequest rebindReportRequest);

    @POST("groups/{groupId}/reports/{reportId}/Rebind")
    Call<Void> rebindReportInGroup(@Path("groupId") String groupId, @Path("reportId") String reportId,
                                    @Body RebindReportRequest rebindReportRequest);

    @POST("reports/{reportId}/UpdateReportContent")
    Call<Report> updateReportContent(@Path("reportId") String reportId,
                                     @Body UpdateReportContentRequest updateReportContentRequest);

    @POST("groups/{groupId}/reports/{reportId}/UpdateReportContent")
    Call<Report> updateReportContentInGroup(@Path("groupId") String groupId, @Path("reportId") String reportId,
                                   @Body UpdateReportContentRequest updateReportContentRequest);

}
