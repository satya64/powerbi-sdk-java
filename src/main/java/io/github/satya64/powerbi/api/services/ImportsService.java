package io.github.satya64.powerbi.api.services;

import io.github.satya64.powerbi.api.model.*;
import lombok.NonNull;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface ImportsService {

    @GET("imports")
    Call<ODataResponse<List<Import>>> getImports();

    @GET("groups/{groupId}/imports")
    Call<ODataResponse<List<Import>>> getImportsInGroup(@Path("groupId") String groupId);

    @GET("imports/{importId}")
    Call<Import> getImport(@Path("importId") String importId);

    @GET("groups/{groupId}/imports/{importId}")
    Call<Import> getImportInGroup(@Path("groupId") String groupId, @Path("importId") String importId);

    @POST("imports")
    Call<Import> postImport(@NonNull @Query("datasetDisplayName") String datasetDisplayName,
                            @Query("nameConflict") ImportConflictHandlerMode nameConflict,
                            @Query("skipReport") boolean skipReport,
                            @Body ImportInfo importInfo);

    @POST("groups/{groupId}/imports")
    Call<Import> postImportInGroup(@Path("groupId") String groupId,
                                   @NonNull @Query("datasetDisplayName") String datasetDisplayName,
                                   @Query("nameConflict") ImportConflictHandlerMode nameConflict,
                                   @Query("skipReport") boolean skipReport,
                                   @Body ImportInfo importInfo);

}
