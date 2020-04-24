package io.github.satya64.powerbi.api.services;

import io.github.satya64.powerbi.api.model.GroupCreationRequest;
import io.github.satya64.powerbi.api.model.GroupUser;
import io.github.satya64.powerbi.api.model.ODataResponse;
import io.github.satya64.powerbi.api.model.Group;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface GroupsService {

    @GET("groups")
    Call<ODataResponse<List<Group>>> getGroups();

    @POST("groups")
    Call<ODataResponse<List<Group>>> createGroup(@Body GroupCreationRequest groupCreationRequest);

    @DELETE("groups/{groupId}")
    Call<Void> deleteGroup(@Path("groupId") String groupId);

    @DELETE("groups/{groupId}/users/{user}")
    Call<Void> deleteUserInGroup(@Path("groupId") String groupId, @Path("user") String user);

    @GET("groups/{groupId}/users")
    Call<ODataResponse<List<GroupUser>>> getGroupUsers(@Path("groupId") String groupId);

    @POST("groups/{groupId}/users")
    Call<Void> addGroupUser(@Path("groupId") String groupId, @Body GroupUser groupUser);

    @PUT("groups/{groupId}/users")
    Call<Void> updateGroupUser(@Path("groupId") String groupId, @Body GroupUser groupUser);

}
