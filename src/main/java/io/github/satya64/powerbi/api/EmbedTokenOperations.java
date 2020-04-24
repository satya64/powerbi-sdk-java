package io.github.satya64.powerbi.api;

import io.github.satya64.powerbi.api.model.EmbedToken;
import io.github.satya64.powerbi.api.model.TokenRequest;
import io.github.satya64.powerbi.api.model.TokenRequestV2;
import io.github.satya64.powerbi.api.services.EmbedTokenService;
import lombok.NonNull;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;

/**
 * Class to handle all embed token generation related operations for reports, dashboard, datasets and dashboard tiles
 */
public class EmbedTokenOperations {

    private EmbedTokenService embedTokenService;

    public EmbedTokenOperations(Retrofit retrofit) {
        this.embedTokenService = retrofit.create(EmbedTokenService.class);
    }

    /**
     * The method requires that below permissions are enabled for the access token passed
     * - Report.ReadWrite.All or Report.Read.All
     * - Dataset.ReadWrite.All or Dataset.Read.All
     * - Content.Create - required only if allowSaveAs specified in TokenRequest
     *
     * @param groupId group id
     * @param reportId report id
     * @param tokenRequest TokenRequest object
     * @return EmbedToken
     * @throws IOException            This exception occurs in case any error with HTTP connection to powerbi REST API
     * @throws PowerBiClientException Wrapper exception class for converting powerbi errors to meaningful messages
     */
    public EmbedToken generateReportTokenInGroup(@NonNull String groupId, @NonNull String reportId, @NonNull TokenRequest tokenRequest) throws IOException, PowerBiClientException {
        Response<EmbedToken> res = embedTokenService.generateReportTokenInGroup(groupId, reportId, tokenRequest).execute();
        return ClientUtils.buildAndSendResponseBody(res);
    }

    /**
     * The method requires that below permissions are enabled for the access token passed
     * - Content.Create
     * - Report.ReadWrite.All or Report.Read.All
     * - Dataset.ReadWrite.All or Dataset.Read.All
     *
     * @param groupId group id
     * @param tokenRequest TokenRequest object
     * @return EmbedToken
     * @throws IOException            This exception occurs in case any error with HTTP connection to powerbi REST API
     * @throws PowerBiClientException Wrapper exception class for converting powerbi errors to meaningful messages
     */
    public EmbedToken generateReportTokenForCreateInGroup(@NonNull String groupId, @NonNull TokenRequest tokenRequest) throws IOException, PowerBiClientException {
        Response<EmbedToken> res = embedTokenService.generateReportTokenForCreateInGroup(groupId, tokenRequest).execute();
        return ClientUtils.buildAndSendResponseBody(res);
    }

    /**
     * The method requires that below permissions are enabled for the access token passed
     * - Content.Create - required only if a target workspace is specified in TokenRequestV2
     * - Report.ReadWrite.All or Report.Read.All - required only if a report is specified in TokenRequestV2
     * - Report.ReadWrite.All - required if allowEdit flag is specified for at least one report in TokenRequestV2
     * - Dataset.ReadWrite.All or Dataset.Read.All
     *
     * @param tokenRequestV2  TokenRequestV2 object
     * @return EmbedToken
     * @throws IOException            This exception occurs in case any error with HTTP connection to powerbi REST API
     * @throws PowerBiClientException Wrapper exception class for converting powerbi errors to meaningful messages
     */
    public EmbedToken generateToken(@NonNull TokenRequestV2 tokenRequestV2) throws IOException, PowerBiClientException {
        Response<EmbedToken> res = embedTokenService.generateToken(tokenRequestV2).execute();
        return ClientUtils.buildAndSendResponseBody(res);
    }

    /**
     * The method requires that below permissions are enabled for the access token passed
     * -  Dataset.ReadWrite.All or Dataset.Read.All
     *
     * @param groupId group id
     * @param datasetId dataset id
     * @param tokenRequest TokenRequest object
     * @return EmbedToken
     * @throws IOException            This exception occurs in case any error with HTTP connection to powerbi REST API
     * @throws PowerBiClientException Wrapper exception class for converting powerbi errors to meaningful messages
     */
    public EmbedToken generateDatasetTokenInGroup(@NonNull String groupId, @NonNull String datasetId, @NonNull TokenRequest tokenRequest) throws IOException, PowerBiClientException {
        Response<EmbedToken> res = embedTokenService.generateDatasetTokenInGroup(groupId, datasetId, tokenRequest).execute();
        return ClientUtils.buildAndSendResponseBody(res);
    }

    /**
     * The method requires that below permissions are enabled for the access token passed
     * - Dashboard.ReadWrite.All or Dashboard.Read.All
     * - Report.ReadWrite.All or Report.Read.All
     * - Dataset.ReadWrite.All or Dataset.Read.All
     *
     * @param groupId group id
     * @param datasetId dataset id
     * @param tokenRequest TokenRequest object
     * @return EmbedToken
     * @throws IOException            This exception occurs in case any error with HTTP connection to powerbi REST API
     * @throws PowerBiClientException Wrapper exception class for converting powerbi errors to meaningful messages
     */
    public EmbedToken generateDashboardTokenInGroup(@NonNull String groupId, @NonNull String datasetId, @NonNull TokenRequest tokenRequest) throws IOException, PowerBiClientException {
        Response<EmbedToken> res = embedTokenService.generateDashboardTokenInGroup(groupId, datasetId, tokenRequest).execute();
        return ClientUtils.buildAndSendResponseBody(res);
    }

    /**
     * The method requires that below permissions are enabled for the access token passed
     * - Dashboard.ReadWrite.All or Dashboard.Read.All
     * - Report.ReadWrite.All or Report.Read.All
     * - Dataset.ReadWrite.All or Dataset.Read.All
     *
     * @param groupId group id
     * @param dashboardId dashboard id
     * @param tileId tile id
     * @param tokenRequest TokenRequest object
     * @return EmbedToken
     * @throws IOException            This exception occurs in case any error with HTTP connection to powerbi REST API
     * @throws PowerBiClientException Wrapper exception class for converting powerbi errors to meaningful messages
     */
    public EmbedToken generateTileTokenInGroup(@NonNull String groupId, @NonNull String dashboardId, @NonNull String tileId, @NonNull TokenRequest tokenRequest) throws IOException, PowerBiClientException {
        Response<EmbedToken> res = embedTokenService.generateTileTokenInGroup(groupId, dashboardId, tileId, tokenRequest).execute();
        return ClientUtils.buildAndSendResponseBody(res);
    }
}
