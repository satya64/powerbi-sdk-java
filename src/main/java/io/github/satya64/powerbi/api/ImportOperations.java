package io.github.satya64.powerbi.api;

import io.github.satya64.powerbi.api.model.*;
import io.github.satya64.powerbi.api.services.DatasetsService;
import io.github.satya64.powerbi.api.services.ImportsService;
import lombok.NonNull;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.List;

/**
 * Class to handle all dataset related operations
 */
public class ImportOperations {

    private ImportsService importsService;

    public ImportOperations(Retrofit retrofit) {
        this.importsService = retrofit.create(ImportsService.class);
    }

    /**
     * The method requires that below permissions are enabled for the access token passed
     * - Dataset.ReadWrite.All or Dataset.Read.All
     *
     * @return {@code ODataResponse<List<Import>>}
     * @throws IOException            This exception occurs in case any error with HTTP connection to powerbi REST API
     * @throws PowerBiClientException Wrapper exception class for converting powerbi errors to meaningful messages
     */
    public ODataResponse<List<Import>> getImports() throws IOException, PowerBiClientException {
        Response<ODataResponse<List<Import>>> res = importsService.getImports().execute();
        return ClientUtils.buildAndSendResponseBody(res);
    }

    /**
     * The method requires that below permissions are enabled for the access token passed
     * - Dataset.ReadWrite.All or Dataset.Read.All
     *
     * @param groupId group id
     * @return {@code ODataResponse<List<Import>>}
     * @throws IOException            This exception occurs in case any error with HTTP connection to powerbi REST API
     * @throws PowerBiClientException Wrapper exception class for converting powerbi errors to meaningful messages
     */
    public ODataResponse<List<Import>> getImportsInGroup(@NonNull String groupId) throws IOException, PowerBiClientException {
        Response<ODataResponse<List<Import>>> res = importsService.getImportsInGroup(groupId).execute();
        return ClientUtils.buildAndSendResponseBody(res);
    }

    /**
     * The method requires that below permissions are enabled for the access token passed
     * - Dataset.ReadWrite.All or Dataset.Read.All
     * @param importId import id
     * @return Import
     * @throws IOException            This exception occurs in case any error with HTTP connection to powerbi REST API
     * @throws PowerBiClientException Wrapper exception class for converting powerbi errors to meaningful messages
     */
    public Import getImport(@NonNull String importId) throws IOException, PowerBiClientException {
        Response<Import> res = importsService.getImport(importId).execute();
        return ClientUtils.buildAndSendResponseBody(res);
    }

    /**
     * The method requires that below permissions are enabled for the access token passed
     * - Dataset.ReadWrite.All or Dataset.Read.All
     * @param groupId group id
     * @param importId import id
     * @return Import
     * @throws IOException            This exception occurs in case any error with HTTP connection to powerbi REST API
     * @throws PowerBiClientException Wrapper exception class for converting powerbi errors to meaningful messages
     */
    public Import getImportInGroup(@NonNull String groupId, @NonNull String importId) throws IOException, PowerBiClientException {
        Response<Import> res = importsService.getImportInGroup(groupId, importId).execute();
        return ClientUtils.buildAndSendResponseBody(res);
    }

    /**
     * The method requires that below permissions are enabled for the access token passed
     * - Dataset.ReadWrite.All
     *
     * @param groupId group id
     * @param datasetDisplayName dataset display name
     * @param nameConflict ImportConflictHandlerMode
     * @param skipReport skip report flag
     * @param importInfoRequest ImportInfo
     * @return Import
     * @throws IOException            This exception occurs in case any error with HTTP connection to powerbi REST API
     * @throws PowerBiClientException Wrapper exception class for converting powerbi errors to meaningful messages
     */
    public Import postImportInGroup(@NonNull String groupId,
                                    @NonNull String datasetDisplayName,
                                    ImportConflictHandlerMode nameConflict,
                                    boolean skipReport,
                                    @NonNull ImportInfo importInfoRequest) throws IOException, PowerBiClientException {
        Response<Import> res = importsService.postImportInGroup(groupId, datasetDisplayName, nameConflict, skipReport,
                importInfoRequest).execute();
        return ClientUtils.buildAndSendResponseBody(res);
    }

    /**
     * The method requires that below permissions are enabled for the access token passed
     * - Dataset.ReadWrite.All
     *
     * @param datasetDisplayName dataset display name
     * @param nameConflict ImportConflictHandlerMode
     * @param skipReport skip report flag
     * @param importInfoRequest ImportInfo
     * @return Import
     * @throws IOException            This exception occurs in case any error with HTTP connection to powerbi REST API
     * @throws PowerBiClientException Wrapper exception class for converting powerbi errors to meaningful messages
     */
    public Import postImport(@NonNull String datasetDisplayName,
                             ImportConflictHandlerMode nameConflict,
                             boolean skipReport,
                             @NonNull ImportInfo importInfoRequest) throws IOException, PowerBiClientException {
        Response<Import> res = importsService.postImport(datasetDisplayName, nameConflict, skipReport,
                importInfoRequest).execute();
        return ClientUtils.buildAndSendResponseBody(res);
    }

}
