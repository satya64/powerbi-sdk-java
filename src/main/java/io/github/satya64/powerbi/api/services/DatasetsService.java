package io.github.satya64.powerbi.api.services;

import io.github.satya64.powerbi.api.model.ODataResponse;
import io.github.satya64.powerbi.api.model.Dataset;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface DatasetsService {

    @GET("datasets")
    Call<ODataResponse<List<Dataset>>> getDatasets();

    @GET("groups/{groupId}/datasets")
    Call<ODataResponse<List<Dataset>>> getDatasetsInGroup(@Path("groupId") String groupId);

    @GET("datasets/{datasetId}")
    Call<Dataset> getDataset(@Path("datasetId") String datasetId);

    @GET("groups/{groupId}/datasets/{datasetId}")
    Call<Dataset> getDatasetInGroup(@Path("groupId") String groupId, @Path("datasetId") String datasetId);

    @DELETE("datasets/{datasetId}")
    Call<Void> deleteDataset(@Path("datasetId") String datasetId);

    @DELETE("groups/{groupId}/datasets/{datasetId}")
    Call<Void> deleteDatasetInGroup(@Path("groupId") String groupId, @Path("datasetId") String datasetId);

}
