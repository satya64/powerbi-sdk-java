package io.github.satya64.powerbi.api.services;

import io.github.satya64.powerbi.api.CustomMockDispatcher;
import io.github.satya64.powerbi.api.TestUtils;
import io.github.satya64.powerbi.api.model.Export;
import io.github.satya64.powerbi.api.model.ExportReportRequest;
import io.github.satya64.powerbi.api.model.ODataResponse;
import io.github.satya64.powerbi.api.model.Report;
import okhttp3.ResponseBody;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

import static io.github.satya64.powerbi.api.model.ExportState.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ReportsServiceTest {

    private MockWebServer mockWebServer = new MockWebServer();

    private ReportsService reportsService;

    @Before
    public void setup() throws IOException {
        mockWebServer.setDispatcher(new CustomMockDispatcher.ReportsServiceMockDispatcher());
        mockWebServer.start();
        reportsService = TestUtils.createService(mockWebServer, ReportsService.class);
    }

    @After
    public void teardown() throws IOException {
        mockWebServer.shutdown();
    }

    @Test
    public void testGetReports() throws IOException {
        Response<ODataResponse<List<Report>>> actual = reportsService.getReports().execute();
        assertNotNull(actual);
        assertNotNull(actual.body());
        assertNotNull(actual.body().getValue());
        assertEquals(1, actual.body().getValue().size());
    }

    @Test
    public void testGetReportsInGroup() throws IOException {
        Response<ODataResponse<List<Report>>> actual = reportsService.getReportsInGroup("123").execute();
        assertNotNull(actual);
        assertNotNull(actual.body());
        assertNotNull(actual.body().getValue());
        assertEquals(1, actual.body().getValue().size());
    }

    @Test
    public void testGetReport() throws IOException {
        Response<Report> actual = reportsService.getReport("456").execute();
        assertNotNull(actual);
        assertNotNull(actual.body());
        assertEquals("report1", actual.body().getName());
    }

    @Test
    public void testGetReportInGroup() throws IOException {
        Response<Report> actual = reportsService.getReportInGroup("123","456").execute();
        assertNotNull(actual);
        assertNotNull(actual.body());
        assertEquals("report1", actual.body().getName());
    }

    @Test
    public void testDeleteReport() throws IOException {
        Response<Void> actual = reportsService.deleteReport("456").execute();
        assertNotNull(actual);
        assertEquals(200, actual.code());
    }

    @Test
    public void testDeleteReportInGroup() throws IOException {
        Response<Void> actual = reportsService.deleteReportInGroup("123","456").execute();
        assertNotNull(actual);
        assertEquals(200, actual.code());
    }

    @Test
    public void testExportReport() throws IOException {
        Response<ResponseBody> actual = reportsService.exportReport("456").execute();
        assertNotNull(actual);
        assertNotNull(actual.body());
        assertEquals(200, actual.code());
    }

    @Test
    public void testExportReportInGroup() throws IOException {
        Response<ResponseBody> actual = reportsService.exportReportInGroup("123","456").execute();
        assertNotNull(actual);
        assertNotNull(actual.body());
        assertEquals(200, actual.code());
    }

    @Test
    public void testExportReportToFile() throws IOException {
        Response<Export> actual = reportsService.exportReportToFile("456", new ExportReportRequest()).execute();
        assertNotNull(actual);
        assertNotNull(actual.body());
        assertEquals(200, actual.code());
        assertEquals(NotStarted, actual.body().getStatus());
    }

    @Test
    public void testExportReportToFileInGroup() throws IOException {
        Response<Export> actual = reportsService.exportReportInGroupToFile("123","456", new ExportReportRequest()).execute();
        assertNotNull(actual);
        assertNotNull(actual.body());
        assertEquals(200, actual.code());
    }

    @Test
    public void testExportReportToFileStatus() throws IOException {
        Response<Export> actual = reportsService.getExportToFileStatus("456", "789").execute();
        assertNotNull(actual);
        assertNotNull(actual.body());
        assertEquals(200, actual.code());
        assertEquals(Running, actual.body().getStatus());
    }

    @Test
    public void testExportReportToFileStatusInGroup() throws IOException {
        Response<Export> actual = reportsService.getExportToFileStatusInGroup("123","456", "789").execute();
        assertNotNull(actual);
        assertNotNull(actual.body());
        assertEquals(Running, actual.body().getStatus());
    }

    @Test
    public void testExportReportToFileStatusSucceeded() throws IOException {
        Response<Export> actual = reportsService.getExportToFileStatus("456", "012").execute();
        assertNotNull(actual);
        assertNotNull(actual.body());
        assertEquals(200, actual.code());
        assertEquals(Succeeded, actual.body().getStatus());
    }

    @Test
    public void testExportReportToFileStatusInGroupSucceeded() throws IOException {
        Response<Export> actual = reportsService.getExportToFileStatusInGroup("123","456", "012").execute();
        assertNotNull(actual);
        assertNotNull(actual.body());
        assertEquals(Succeeded, actual.body().getStatus());
    }
}
