package io.github.satya64.powerbi.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.satya64.powerbi.api.model.Group;
import okhttp3.mockwebserver.MockWebServer;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

public final class TestUtils {

    private final static ObjectMapper objectMapper;

    static {
        objectMapper = new ObjectMapper();
    }

    public static <T> T createService(MockWebServer mockWebServer, Class<T> className) {
        return new Retrofit.Builder()
                .baseUrl(mockWebServer.url("/"))
                .addConverterFactory(JacksonConverterFactory.create())
                .build()
                .create(className);
    }

    static public List<Group> createGroups() throws IOException {
        return createPOJOList("/data/groups.json", Group.class);
    }

    public static String createGroupsResponse() {
        return readJson("/data/groups.json");
    }

    public static String createReportsResponse() {
        return readJson("/data/reports.json");
    }

    public static String createReportResponse() {
        return readJson("/data/report.json");
    }

    public static String createDatasetsResponse() {
        return readJson("/data/datasets.json");
    }

    public static String createDatasetResponse() {
        return readJson("/data/dataset.json");
    }

    public static String readJson(String fileName) {
        try (InputStream fis = TestUtils.class.getResourceAsStream(fileName)) {
            return convertInputStreamToString(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    static private <T> List<T> createPOJOList(String path, Class<T> valueType) throws IOException {
        InputStream inputStream =
                TestUtils.class.getResourceAsStream(path);
        List<T> pojos;
        try {
            pojos = objectMapper.readValue(
                    inputStream,
                    objectMapper.getTypeFactory().constructCollectionType(List.class, valueType));
        } finally {
            inputStream.close();
        }

        return pojos;
    }

    private static String convertInputStreamToString(InputStream inputStream) throws IOException {
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length;
        while ((length = inputStream.read(buffer)) != -1) {
            result.write(buffer, 0, length);
        }
        return result.toString(StandardCharsets.UTF_8.name());
    }

}
