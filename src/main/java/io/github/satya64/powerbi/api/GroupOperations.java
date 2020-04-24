package io.github.satya64.powerbi.api;

import io.github.satya64.powerbi.api.model.Group;
import io.github.satya64.powerbi.api.model.GroupCreationRequest;
import io.github.satya64.powerbi.api.model.GroupUser;
import io.github.satya64.powerbi.api.model.ODataResponse;
import io.github.satya64.powerbi.api.services.GroupsService;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.List;

/**
 * Class to handle all group related operations
 */
public class GroupOperations {

    private GroupsService groupsService;

    public GroupOperations(Retrofit retrofit) {
        this.groupsService = retrofit.create(GroupsService.class);
    }

    /**
     * The method requires that below permissions enabled for the access token passed
     * - Workspace.Read.All or Workspace.ReadWrite.All
     *
     * @return ODataResponse<List < Group>>
     * @throws IOException            This exception occurs in case any error with HTTP connection to powerbi REST API
     * @throws PowerBiClientException Wrapper exception class for converting powerbi errors to meaningful messages
     */
    public ODataResponse<List<Group>> getGroups() throws IOException, PowerBiClientException {
        Response<ODataResponse<List<Group>>> res = groupsService.getGroups().execute();
        return ClientUtils.buildAndSendResponseBody(res);
    }

    /**
     * The method requires that below permissions enabled for the access token passed
     * - Workspace.ReadWrite.All
     *
     * @param groupCreationRequest Valid GroupCreationRequest object
     * @return ODataResponse<List < Group>>
     * @throws IOException            This exception occurs in case any error with HTTP connection to powerbi REST API
     * @throws PowerBiClientException Wrapper exception class for converting powerbi errors to meaningful messages
     */
    public ODataResponse<List<Group>> createGroup(GroupCreationRequest groupCreationRequest) throws IOException, PowerBiClientException {
        Response<ODataResponse<List<Group>>> res = groupsService.createGroup(groupCreationRequest).execute();
        return ClientUtils.buildAndSendResponseBody(res);
    }

    /**
     * The method requires that below permissions enabled for the access token passed
     * - Workspace.ReadWrite.All
     *
     * @param groupId groupId to delete
     * @return int
     * @throws IOException            This exception occurs in case any error with HTTP connection to powerbi REST API
     * @throws PowerBiClientException Wrapper exception class for converting powerbi errors to meaningful messages
     */
    public int deleteGroup(String groupId) throws IOException, PowerBiClientException {
        Response<Void> res = groupsService.deleteGroup(groupId).execute();
        return ClientUtils.buildAndSendResponseCode(res);
    }

    /**
     * The method requires that below permissions enabled for the access token passed
     * - Workspace.ReadWrite.All
     *
     * @param groupId group id
     * @param user    user to delete from group with groupId
     * @return int
     * @throws IOException            This exception occurs in case any error with HTTP connection to powerbi REST API
     * @throws PowerBiClientException Wrapper exception class for converting powerbi errors to meaningful messages
     */
    public int deleteUserInGroup(String groupId, String user) throws IOException, PowerBiClientException {
        Response<Void> res = groupsService.deleteUserInGroup(groupId, user).execute();
        return ClientUtils.buildAndSendResponseCode(res);
    }

    /**
     * The method requires that below permissions enabled for the access token passed
     * - Workspace.Read.All or Workspace.ReadWrite.All
     *
     * @param groupId group id
     * @return ODataResponse<List < GroupUser>>
     * @throws IOException            This exception occurs in case any error with HTTP connection to powerbi REST API
     * @throws PowerBiClientException Wrapper exception class for converting powerbi errors to meaningful messages
     */
    public ODataResponse<List<GroupUser>> getGroupUsers(String groupId) throws IOException, PowerBiClientException {
        Response<ODataResponse<List<GroupUser>>> res = groupsService.getGroupUsers(groupId).execute();
        return ClientUtils.buildAndSendResponseBody(res);
    }

    /**
     * The method requires that below permissions enabled for the access token passed
     * - Workspace.ReadWrite.All
     *
     * @param groupId   group id
     * @param groupUser GroupUser object to be added to group
     * @return int
     * @throws IOException            This exception occurs in case any error with HTTP connection to powerbi REST API
     * @throws PowerBiClientException Wrapper exception class for converting powerbi errors to meaningful messages
     */
    public int addGroupUser(String groupId, GroupUser groupUser) throws IOException, PowerBiClientException {
        Response<Void> res = groupsService.addGroupUser(groupId, groupUser).execute();
        return ClientUtils.buildAndSendResponseCode(res);
    }

    /**
     * The method requires that below permissions enabled for the access token passed
     * - Workspace.ReadWrite.All
     *
     * @param groupId   group id
     * @param groupUser GroupUser object to be updated to group
     * @return int
     * @throws IOException            This exception occurs in case any error with HTTP connection to powerbi REST API
     * @throws PowerBiClientException Wrapper exception class for converting powerbi errors to meaningful messages
     */
    public int updateGroupUser(String groupId, GroupUser groupUser) throws IOException, PowerBiClientException {
        Response<Void> res = groupsService.updateGroupUser(groupId, groupUser).execute();
        return ClientUtils.buildAndSendResponseCode(res);
    }
}
