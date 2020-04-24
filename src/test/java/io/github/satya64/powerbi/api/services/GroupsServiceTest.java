package io.github.satya64.powerbi.api.services;

import io.github.satya64.powerbi.api.CustomMockDispatcher;
import io.github.satya64.powerbi.api.TestUtils;
import io.github.satya64.powerbi.api.model.Group;
import io.github.satya64.powerbi.api.model.ODataResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class GroupsServiceTest {

    private MockWebServer mockWebServer = new MockWebServer();

    private GroupsService groupsService;

    @Before
    public void setup() throws IOException {
        mockWebServer.setDispatcher(new CustomMockDispatcher.GroupServiceMockDispatcher());
        mockWebServer.start();
        groupsService = TestUtils.createService(mockWebServer, GroupsService.class);
    }

    @After
    public void teardown() throws IOException {
        mockWebServer.shutdown();
    }

    @Test
    public void testGetGroups() throws IOException {
        Response<ODataResponse<List<Group>>> actual = groupsService.getGroups().execute();
        assertNotNull(actual);
        assertNotNull(actual.body());
        assertNotNull(actual.body().getValue());
        assertEquals(2, actual.body().getValue().size());
    }

}
