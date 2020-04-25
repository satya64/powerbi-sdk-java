package io.github.satya64.powerbi.api;

import io.github.satya64.powerbi.api.model.Dataset;
import io.github.satya64.powerbi.api.model.ODataResponse;
import io.github.satya64.powerbi.api.services.DatasetsService;
import lombok.NonNull;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.List;

/**
 * Class to handle all dataset related operations
 */
public class DatasetOperations {

    private DatasetsService datasetsService;

    public DatasetOperations(Retrofit retrofit) {
        this.datasetsService = retrofit.create(DatasetsService.class);
    }

    /**
     * The method requires that below permissions are enabled for the access token passed
     * - Dataset.ReadWrite.All or Dataset.Read.All
     *
     * @return {@code ODataResponse<List<Dataset>>}
     * @throws IOException            This exception occurs in case any error with HTTP connection to powerbi REST API
     * @throws PowerBiClientException Wrapper exception class for converting powerbi errors to meaningful messages
     */
    public ODataResponse<List<Dataset>> getDatasets() throws IOException, PowerBiClientException {
        Response<ODataResponse<List<Dataset>>> res = datasetsService.getDatasets().execute();
        return ClientUtils.buildAndSendResponseBody(res);
    }

    /**
     * The method requires that below permissions are enabled for the access token passed
     * - Dataset.ReadWrite.All or Dataset.Read.All
     *
     * @param groupId group id
     * @return {@code ODataResponse<List<Dataset>>}
     * @throws IOException            This exception occurs in case any error with HTTP connection to powerbi REST API
     * @throws PowerBiClientException Wrapper exception class for converting powerbi errors to meaningful messages
     */
    public ODataResponse<List<Dataset>> getDatasetsInGroup(@NonNull String groupId) throws IOException, PowerBiClientException {
        Response<ODataResponse<List<Dataset>>> res = datasetsService.getDatasetsInGroup(groupId).execute();
        return ClientUtils.buildAndSendResponseBody(res);
    }

    /**
     * The method requires that below permissions are enabled for the access token passed
     * - Dataset.ReadWrite.All or Dataset.Read.All
     * @param datasetId dataset id
     * @return Dataset
     * @throws IOException            This exception occurs in case any error with HTTP connection to powerbi REST API
     * @throws PowerBiClientException Wrapper exception class for converting powerbi errors to meaningful messages
     */
    public Dataset getDataset(@NonNull String datasetId) throws IOException, PowerBiClientException {
        Response<Dataset> res = datasetsService.getDataset(datasetId).execute();
        return ClientUtils.buildAndSendResponseBody(res);
    }

    /**
     * The method requires that below permissions are enabled for the access token passed
     * - Dataset.ReadWrite.All or Dataset.Read.All
     * @param groupId group id
     * @param datasetId dataset id
     * @return Dataset
     * @throws IOException            This exception occurs in case any error with HTTP connection to powerbi REST API
     * @throws PowerBiClientException Wrapper exception class for converting powerbi errors to meaningful messages
     */
    public Dataset getDatasetInGroup(@NonNull String groupId, @NonNull String datasetId) throws IOException, PowerBiClientException {
        Response<Dataset> res = datasetsService.getDatasetInGroup(groupId, datasetId).execute();
        return ClientUtils.buildAndSendResponseBody(res);
    }

    /**
     * The method requires that below permissions are enabled for the access token passed
     * - Dataset.ReadWrite.All
     *
     * @param groupId group id
     * @param datasetId dataset id
     * @return int
     * @throws IOException            This exception occurs in case any error with HTTP connection to powerbi REST API
     * @throws PowerBiClientException Wrapper exception class for converting powerbi errors to meaningful messages
     */
    public int deleteDatasetInGroup(@NonNull String groupId, @NonNull String datasetId) throws IOException, PowerBiClientException {
        Response<Void> res = datasetsService.deleteDatasetInGroup(groupId, datasetId).execute();
        return ClientUtils.buildAndSendResponseCode(res);
    }

    /**
     * The method requires that below permissions are enabled for the access token passed
     * - Dataset.ReadWrite.All
     *
     * @param datasetId dataset id
     * @return int
     * @throws IOException            This exception occurs in case any error with HTTP connection to powerbi REST API
     * @throws PowerBiClientException Wrapper exception class for converting powerbi errors to meaningful messages
     */
    public int deleteDataset(@NonNull String datasetId) throws IOException, PowerBiClientException {
        Response<Void> res = datasetsService.deleteDataset(datasetId).execute();
        return ClientUtils.buildAndSendResponseCode(res);
    }

}
