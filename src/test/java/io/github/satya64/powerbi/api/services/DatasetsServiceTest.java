package io.github.satya64.powerbi.api.services;

import io.github.satya64.powerbi.api.CustomMockDispatcher;
import io.github.satya64.powerbi.api.TestUtils;
import io.github.satya64.powerbi.api.model.Dataset;
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

public class DatasetsServiceTest {

    private MockWebServer mockWebServer = new MockWebServer();

    private DatasetsService datasetsService;

    @Before
    public void setup() throws IOException {
        mockWebServer.setDispatcher(new CustomMockDispatcher.DatasetsServiceMockDispatcher());
        mockWebServer.start();
        datasetsService = TestUtils.createService(mockWebServer, DatasetsService.class);
    }

    @After
    public void teardown() throws IOException {
        mockWebServer.shutdown();
    }

    @Test
    public void testGetDatasets() throws IOException {
        Response<ODataResponse<List<Dataset>>> actual = datasetsService.getDatasets().execute();
        assertNotNull(actual);
        assertNotNull(actual.body());
        assertNotNull(actual.body().getValue());
        assertEquals(1, actual.body().getValue().size());
    }

    @Test
    public void testGetDatasetsInGroup() throws IOException {
        Response<ODataResponse<List<Dataset>>> actual = datasetsService.getDatasetsInGroup("123").execute();
        assertNotNull(actual);
        assertNotNull(actual.body());
        assertNotNull(actual.body().getValue());
        assertEquals(1, actual.body().getValue().size());
    }

    @Test
    public void testGetDataset() throws IOException {
        Response<Dataset> actual = datasetsService.getDataset("456").execute();
        assertNotNull(actual);
        assertNotNull(actual.body());
        assertEquals("ds1", actual.body().getName());
    }

    @Test
    public void testGetDatasetInGroup() throws IOException {
        Response<Dataset> actual = datasetsService.getDatasetInGroup("123","456").execute();
        assertNotNull(actual);
        assertNotNull(actual.body());
        assertEquals("ds1", actual.body().getName());
    }

    @Test
    public void testDeleteDataset() throws IOException {
        Response<Void> actual = datasetsService.deleteDataset("456").execute();
        assertNotNull(actual);
        assertEquals(200, actual.code());
    }

    @Test
    public void testDeleteDatasetInGroup() throws IOException {
        Response<Void> actual = datasetsService.deleteDatasetInGroup("123","456").execute();
        assertNotNull(actual);
        assertEquals(200, actual.code());
    }

}
