package io.github.satya64.powerbi.api;

import io.github.satya64.powerbi.api.model.*;
import io.github.satya64.powerbi.api.services.ReportsService;
import lombok.NonNull;
import lombok.Value;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.List;

/**
 * Class to handle all report related operations
 */
public class ReportOperations {

    private ReportsService reportsService;

    public ReportOperations(Retrofit retrofit) {
        this.reportsService = retrofit.create(ReportsService.class);
    }

    /**
     * The method requires that below permissions enabled for the access token passed
     * - Report.ReadWrite.All or Report.Read.All
     *
     * @return {@code ODataResponse<List<Report>>}
     * @throws IOException            This exception occurs in case any error with HTTP connection to powerbi REST API
     * @throws PowerBiClientException Wrapper exception class for converting powerbi errors to meaningful messages
     */
    public ODataResponse<List<Report>> getReports() throws IOException, PowerBiClientException {
        Response<ODataResponse<List<Report>>> res = reportsService.getReports().execute();
        return ClientUtils.buildAndSendResponseBody(res);
    }

    /**
     * The method requires that below permissions enabled for the access token passed
     * - Report.ReadWrite.All or Report.Read.All
     *
     * @param groupId group id
     * @return {@code ODataResponse<List<Report>>}
     * @throws IOException            This exception occurs in case any error with HTTP connection to powerbi REST API
     * @throws PowerBiClientException Wrapper exception class for converting powerbi errors to meaningful messages
     */
    public ODataResponse<List<Report>> getReportsInGroup(@NonNull String groupId) throws IOException, PowerBiClientException {
        Response<ODataResponse<List<Report>>> res = reportsService.getReportsInGroup(groupId).execute();
        return ClientUtils.buildAndSendResponseBody(res);
    }

    /**
     * The method requires that below permissions enabled for the access token passed
     * - Report.ReadWrite.All or Report.Read.All
     *
     * @param reportId report id
     * @return Report
     * @throws IOException            This exception occurs in case any error with HTTP connection to powerbi REST API
     * @throws PowerBiClientException Wrapper exception class for converting powerbi errors to meaningful messages
     */
    public Report getReport(@NonNull String reportId) throws IOException, PowerBiClientException {
        Response<Report> res = reportsService.getReport(reportId).execute();
        return ClientUtils.buildAndSendResponseBody(res);
    }

    /**
     * The method requires that below permissions enabled for the access token passed
     * - Report.ReadWrite.All or Report.Read.All
     *
     * @param groupId group id
     * @param reportId report id
     * @return Report
     * @throws IOException            This exception occurs in case any error with HTTP connection to powerbi REST API
     * @throws PowerBiClientException Wrapper exception class for converting powerbi errors to meaningful messages
     */
    public Report getReportInGroup(@NonNull String groupId, @NonNull String reportId) throws IOException, PowerBiClientException {
        Response<Report> res = reportsService.getReportInGroup(groupId, reportId).execute();
        return ClientUtils.buildAndSendResponseBody(res);
    }

    /**
     * The method requires that below permissions enabled for the access token passed
     * - Content.Create
     *
     * @param reportId           report id
     * @param cloneReportRequest Clone report request object
     * @return Report
     * @throws IOException            This exception occurs in case any error with HTTP connection to powerbi REST API
     * @throws PowerBiClientException Wrapper exception class for converting powerbi errors to meaningful messages
     */
    public Report cloneReport(@NonNull String reportId, @NonNull CloneReportRequest cloneReportRequest) throws IOException, PowerBiClientException {
        Response<Report> res = reportsService.cloneReport(reportId, cloneReportRequest).execute();
        return ClientUtils.buildAndSendResponseBody(res);
    }

    /**
     * The method requires that below permissions enabled for the access token passed
     * - Content.Create
     *
     * @param groupId            group id
     * @param reportId           report id
     * @param cloneReportRequest Clone report request object
     * @return Report
     * @throws IOException            This exception occurs in case any error with HTTP connection to powerbi REST API
     * @throws PowerBiClientException Wrapper exception class for converting powerbi errors to meaningful messages
     */
    public Report cloneReportInGroup(@NonNull String groupId, @NonNull String reportId, @NonNull CloneReportRequest cloneReportRequest) throws IOException, PowerBiClientException {
        Response<Report> res = reportsService.cloneReportInGroup(groupId, reportId, cloneReportRequest).execute();
        return ClientUtils.buildAndSendResponseBody(res);
    }

    /**
     * The method requires that below permissions enabled for the access token passed
     * - Report.ReadWrite.All or Report.Read.All
     *
     * @param reportId report id
     * @return ResponseBody with file with Media Type: 'application/zip'
     * @throws IOException            This exception occurs in case any error with HTTP connection to powerbi REST API
     * @throws PowerBiClientException Wrapper exception class for converting powerbi errors to meaningful messages
     */
    public ResponseBody exportReport(String reportId) throws IOException, PowerBiClientException {
        Response<ResponseBody> res = reportsService.exportReport(reportId).execute();
        return ClientUtils.buildAndSendResponseBody(res);
    }

    /**
     * The method requires that below permissions enabled for the access token passed
     * - Report.ReadWrite.All or Report.Read.All
     *
     * @param groupId  group id
     * @param reportId report id
     * @return ResponseBody with file with Media Type: 'application/zip'
     * @throws IOException            This exception occurs in case any error with HTTP connection to powerbi REST API
     * @throws PowerBiClientException Wrapper exception class for converting powerbi errors to meaningful messages
     */
    public ResponseBody exportReportInGroup(@NonNull String groupId, @NonNull String reportId) throws IOException, PowerBiClientException {
        Response<ResponseBody> res = reportsService.exportReportInGroup(groupId, reportId).execute();
        return ClientUtils.buildAndSendResponseBody(res);
    }

    /**
     * The method requires that below permissions enabled for the access token passed
     * - Report.ReadWrite.All or Report.Read.All
     *
     * @param groupId group id
     * @return {@code ODataResponse<List<Datasource>>}
     * @throws IOException            This exception occurs in case any error with HTTP connection to powerbi REST API
     * @throws PowerBiClientException Wrapper exception class for converting powerbi errors to meaningful messages
     */
    public ODataResponse<List<Datasource>> getReportDatasources(@NonNull String groupId) throws IOException, PowerBiClientException {
        Response<ODataResponse<List<Datasource>>> res = reportsService.getReportDatasources(groupId).execute();
        return ClientUtils.buildAndSendResponseBody(res);
    }

    /**
     * The method requires that below permissions enabled for the access token passed
     * - Report.ReadWrite.All or Report.Read.All
     *
     * @param groupId  group id
     * @param reportId report id
     * @return {@code ODataResponse<List<Datasource>>}
     * @throws IOException            This exception occurs in case any error with HTTP connection to powerbi REST API
     * @throws PowerBiClientException Wrapper exception class for converting powerbi errors to meaningful messages
     */
    public ODataResponse<List<Datasource>> getReportDatasourcesInGroup(@NonNull String groupId, @NonNull String reportId) throws IOException, PowerBiClientException {
        Response<ODataResponse<List<Datasource>>> res = reportsService.getReportDatasourcesInGroup(groupId, reportId).execute();
        return ClientUtils.buildAndSendResponseBody(res);
    }

    /**
     * The method requires that below permissions enabled for the access token passed
     * - Report.ReadWrite.All
     *
     * @param reportId report id
     * @return int
     * @throws IOException            This exception occurs in case any error with HTTP connection to powerbi REST API
     * @throws PowerBiClientException Wrapper exception class for converting powerbi errors to meaningful messages
     */
    public int deleteReport(@NonNull String reportId) throws IOException, PowerBiClientException {
        Response<Void> res = reportsService.deleteReport(reportId).execute();
        return ClientUtils.buildAndSendResponseCode(res);
    }

    /**
     * The method requires that below permissions enabled for the access token passed
     * - Report.ReadWrite.All
     *
     * @param groupId  group id
     * @param reportId report id
     * @return int
     * @throws IOException            This exception occurs in case any error with HTTP connection to powerbi REST API
     * @throws PowerBiClientException Wrapper exception class for converting powerbi errors to meaningful messages
     */
    public int deleteReportInGroup(@NonNull String groupId, @NonNull String reportId) throws IOException, PowerBiClientException {
        Response<Void> res = reportsService.deleteReportInGroup(groupId, reportId).execute();
        return ClientUtils.buildAndSendResponseCode(res);
    }

    /**
     * The method requires that below permissions enabled for the access token passed
     * - Report.ReadWrite.All or Report.Read.All
     * - Dataset.ReadWrite.All or Dataset.Read.All
     *
     * @param reportId            report id
     * @param exportReportRequest valid ExportReportRequest object
     * @return Export
     * @throws IOException            This exception occurs in case any error with HTTP connection to powerbi REST API
     * @throws PowerBiClientException Wrapper exception class for converting powerbi errors to meaningful messages
     */
    public Export exportReportToFile(@NonNull String reportId, @NonNull ExportReportRequest exportReportRequest) throws IOException, PowerBiClientException {
        Response<Export> res = reportsService.exportReportToFile(reportId, exportReportRequest).execute();
        return ClientUtils.buildAndSendResponseBody(res);
    }

    /**
     * The method requires that below permissions enabled for the access token passed
     * - Report.ReadWrite.All or Report.Read.All
     * - Dataset.ReadWrite.All or Dataset.Read.All
     *
     * @param groupId             group id
     * @param reportId            report id
     * @param exportReportRequest valid ExportReportRequest object
     * @return Export
     * @throws IOException            This exception occurs in case any error with HTTP connection to powerbi REST API
     * @throws PowerBiClientException Wrapper exception class for converting powerbi errors to meaningful messages
     */
    public Export exportReportInGroupToFile(@NonNull String groupId, @NonNull String reportId, @NonNull ExportReportRequest exportReportRequest) throws IOException, PowerBiClientException {
        Response<Export> res = reportsService.exportReportInGroupToFile(groupId, reportId, exportReportRequest).execute();
        return ClientUtils.buildAndSendResponseBody(res);
    }

    /**
     * The method requires that below permissions enabled for the access token passed
     * - Report.ReadWrite.All or Report.Read.All
     *
     * @param reportId report id
     * @param exportId export id
     * @return Export
     * @throws IOException            This exception occurs in case any error with HTTP connection to powerbi REST API
     * @throws PowerBiClientException Wrapper exception class for converting powerbi errors to meaningful messages
     */
    public Export exportReportToFileStatus(@NonNull String reportId, @NonNull String exportId) throws IOException, PowerBiClientException {
        Response<Export> res = reportsService.getExportToFileStatus(reportId, exportId).execute();
        return ClientUtils.buildAndSendResponseBody(res);
    }

    /**
     * The method requires that below permissions enabled for the access token passed
     * - Report.ReadWrite.All or Report.Read.All
     *
     * @param groupId  group id
     * @param reportId report id
     * @param exportId export id
     * @return Export
     * @throws IOException            This exception occurs in case any error with HTTP connection to powerbi REST API
     * @throws PowerBiClientException Wrapper exception class for converting powerbi errors to meaningful messages
     */
    public Export exportReportInGroupToFileStatus(@NonNull String groupId, @NonNull String reportId, @NonNull String exportId) throws IOException, PowerBiClientException {
        Response<Export> res = reportsService.getExportToFileStatusInGroup(groupId, reportId, exportId).execute();
        return ClientUtils.buildAndSendResponseBody(res);
    }

    /**
     * The method requires that below permissions enabled for the access token passed
     * - Report.ReadWrite.All or Report.Read.All
     *
     * @param reportId report id
     * @param exportId export id
     * @return ResponseBody with file with Media Types: "application/*", "image/*", "text/csv", "text/xml", "multipart/related"
     * @throws IOException            This exception occurs in case any error with HTTP connection to powerbi REST API
     * @throws PowerBiClientException Wrapper exception class for converting powerbi errors to meaningful messages
     */
    public ResponseBody getFileOfExportToFile(@NonNull String reportId, @NonNull String exportId) throws IOException, PowerBiClientException {
        Response<ResponseBody> res = reportsService.getFileOfExportToFile(reportId, exportId).execute();
        return ClientUtils.buildAndSendResponseBody(res);
    }

    /**
     * The method requires that below permissions enabled for the access token passed
     * - Report.ReadWrite.All or Report.Read.All
     *
     * @param groupId  group id
     * @param reportId report id
     * @param exportId export id
     * @return ResponseBody with file with Media Types: "application/*", "image/*", "text/csv", "text/xml", "multipart/related"
     * @throws IOException            This exception occurs in case any error with HTTP connection to powerbi REST API
     * @throws PowerBiClientException Wrapper exception class for converting powerbi errors to meaningful messages
     */
    public ResponseBody getFileOfExportToFileInGroup(@NonNull String groupId, @NonNull String reportId, @NonNull String exportId) throws IOException, PowerBiClientException {
        Response<ResponseBody> res = reportsService.getFileOfExportToFileInGroup(groupId, reportId, exportId).execute();
        return ClientUtils.buildAndSendResponseBody(res);
    }

    /**
     * The method requires that below permissions enabled for the access token passed
     * - Report.ReadWrite.All or Report.Read.All
     *
     * @param reportId report id
     * @param pageName page name
     * @return Page page object
     * @throws IOException            This exception occurs in case any error with HTTP connection to powerbi REST API
     * @throws PowerBiClientException Wrapper exception class for converting powerbi errors to meaningful messages
     */
    public Page getPage(@NonNull String reportId, @NonNull String pageName) throws IOException, PowerBiClientException {
        Response<Page> res = reportsService.getPage(reportId, pageName).execute();
        return ClientUtils.buildAndSendResponseBody(res);
    }

    /**
     * The method requires that below permissions enabled for the access token passed
     * - Report.ReadWrite.All or Report.Read.All
     *
     * @param groupId group id
     * @param reportId report id
     * @param pageName page name
     * @return Page page object
     * @throws IOException            This exception occurs in case any error with HTTP connection to powerbi REST API
     * @throws PowerBiClientException Wrapper exception class for converting powerbi errors to meaningful messages
     */
    public Page getPageInGroup(@NonNull String groupId, @NonNull String reportId, @NonNull String pageName) throws IOException, PowerBiClientException {
        Response<Page> res = reportsService.getPageInGroup(groupId, reportId, pageName).execute();
        return ClientUtils.buildAndSendResponseBody(res);
    }

    /**
     * The method requires that below permissions enabled for the access token passed
     * - Report.ReadWrite.All or Report.Read.All
     *
     * @param reportId report id
     * @return {@code ODataResponse<List<Page>>}
     * @throws IOException            This exception occurs in case any error with HTTP connection to powerbi REST API
     * @throws PowerBiClientException Wrapper exception class for converting powerbi errors to meaningful messages
     */
    public ODataResponse<List<Page>> getPages(@NonNull String reportId) throws IOException, PowerBiClientException {
        Response<ODataResponse<List<Page>>> res = reportsService.getPages(reportId).execute();
        return ClientUtils.buildAndSendResponseBody(res);
    }

    /**
     * The method requires that below permissions enabled for the access token passed
     * - Report.ReadWrite.All or Report.Read.All
     *
     * @param groupId group id
     * @param reportId report id
     * @return {@code ODataResponse<List<Page>>}
     * @throws IOException            This exception occurs in case any error with HTTP connection to powerbi REST API
     * @throws PowerBiClientException Wrapper exception class for converting powerbi errors to meaningful messages
     */
    public ODataResponse<List<Page>> getPagesInGroup(@NonNull String groupId, @NonNull String reportId) throws IOException, PowerBiClientException {
        Response<ODataResponse<List<Page>>> res = reportsService.getPagesInGroup(groupId, reportId).execute();
        return ClientUtils.buildAndSendResponseBody(res);
    }

    /**
     * The method requires that below permissions enabled for the access token passed
     * - Report.ReadWrite.All
     *
     * @param reportId report id
     * @param rebindReportRequest RebindReportRequest
     * @return int
     * @throws IOException            This exception occurs in case any error with HTTP connection to powerbi REST API
     * @throws PowerBiClientException Wrapper exception class for converting powerbi errors to meaningful messages
     */
    public int rebindReport(@NonNull String reportId, @NonNull RebindReportRequest rebindReportRequest) throws IOException, PowerBiClientException {
        Response<Void> res = reportsService.rebindReport(reportId, rebindReportRequest).execute();
        return ClientUtils.buildAndSendResponseCode(res);
    }

    /**
     * The method requires that below permissions enabled for the access token passed
     * - Report.ReadWrite.All
     *
     * @param groupId group id
     * @param reportId report id
     * @param rebindReportRequest RebindReportRequest
     * @return int
     * @throws IOException            This exception occurs in case any error with HTTP connection to powerbi REST API
     * @throws PowerBiClientException Wrapper exception class for converting powerbi errors to meaningful messages
     */
    public int rebindReportInGroup(@NonNull String groupId, @NonNull String reportId, @NonNull RebindReportRequest rebindReportRequest) throws IOException, PowerBiClientException {
        Response<Void> res = reportsService.rebindReportInGroup(groupId, reportId, rebindReportRequest).execute();
        return ClientUtils.buildAndSendResponseCode(res);
    }

    /**
     * The method requires that below permissions enabled for the access token passed
     * - Report.ReadWrite.All
     *
     * @param reportId report id
     * @param updateReportContentRequest UpdateReportContentRequest
     * @return Report
     * @throws IOException            This exception occurs in case any error with HTTP connection to powerbi REST API
     * @throws PowerBiClientException Wrapper exception class for converting powerbi errors to meaningful messages
     */
    public Report updateReportContent(@NonNull String reportId, @NonNull UpdateReportContentRequest updateReportContentRequest) throws IOException, PowerBiClientException {
        Response<Report> res = reportsService.updateReportContent(reportId, updateReportContentRequest).execute();
        return ClientUtils.buildAndSendResponseBody(res);
    }

    /**
     * The method requires that below permissions enabled for the access token passed
     * - Report.ReadWrite.All
     *
     * @param groupId group id
     * @param reportId report id
     * @param updateReportContentRequest UpdateReportContentRequest
     * @return Report
     * @throws IOException            This exception occurs in case any error with HTTP connection to powerbi REST API
     * @throws PowerBiClientException Wrapper exception class for converting powerbi errors to meaningful messages
     */
    public Report updateReportContentInGroup(@NonNull String groupId, @NonNull String reportId, @NonNull UpdateReportContentRequest updateReportContentRequest) throws IOException, PowerBiClientException {
        Response<Report> res = reportsService.updateReportContentInGroup(groupId, reportId, updateReportContentRequest).execute();
        return ClientUtils.buildAndSendResponseBody(res);
    }

}
