package io.github.satya64.powerbi.api;

import okhttp3.mockwebserver.Dispatcher;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.RecordedRequest;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class CustomMockDispatcher extends Dispatcher {

    @NotNull
    @Override
    public MockResponse dispatch(@NotNull RecordedRequest request) {
        switch (request.getPath()) {
            case "/groups":
                return response200(TestUtils.createGroupsResponse());
//            case "reports":
//                return new MockResponse().setResponseCode(200).setBody("version=9");
//            case "groups/1234-abcd/reports":
//                return new MockResponse().setResponseCode(200).setBody(TestUtils.readJson("/data/groups.json"));
        }
        return response404();
    }

    public static class GroupServiceMockDispatcher extends Dispatcher {

        @NotNull
        @Override
        public MockResponse dispatch(@NotNull RecordedRequest recordedRequest) throws InterruptedException {
            switch (recordedRequest.getPath()) {
                case "/groups":
                    return response200(TestUtils.createGroupsResponse());
            }
            return response404();
        }
    }

    public static class ReportsServiceMockDispatcher extends Dispatcher {

        @NotNull
        @Override
        public MockResponse dispatch(@NotNull RecordedRequest recordedRequest) {
            switch (Objects.requireNonNull(recordedRequest.getMethod())) {
                case "GET":
                    switch (Objects.requireNonNull(recordedRequest.getPath())) {
                        case "/reports":
                            return response200(TestUtils.createReportsResponse());
                        case "/groups/123/reports":
                            return response200(TestUtils.createReportsResponse());
                        case "/reports/456":
                            return response200(TestUtils.createReportResponse());
                        case "/groups/123/reports/456":
                            return response200(TestUtils.createReportResponse());
                    }
                case "DELETE":
                    switch (Objects.requireNonNull(recordedRequest.getPath())) {
                        case "/reports/456":
                        case "/groups/123/reports/456":
                            return response200(null);
                    }
            }
            return response404();
        }
    }

    public static class DatasetsServiceMockDispatcher extends Dispatcher {

        @NotNull
        @Override
        public MockResponse dispatch(@NotNull RecordedRequest recordedRequest) {
            switch (Objects.requireNonNull(recordedRequest.getMethod())) {
                case "GET":
                    switch (Objects.requireNonNull(recordedRequest.getPath())) {
                        case "/datasets":
                            return response200(TestUtils.createDatasetsResponse());
                        case "/groups/123/datasets":
                            return response200(TestUtils.createDatasetsResponse());
                        case "/datasets/456":
                            return response200(TestUtils.createDatasetResponse());
                        case "/groups/123/datasets/456":
                            return response200(TestUtils.createDatasetResponse());
                    }
                case "DELETE":
                    switch (Objects.requireNonNull(recordedRequest.getPath())) {
                        case "/datasets/456":
                        case "/groups/123/datasets/456":
                            return response200(null);
                    }
            }
            return response404();
        }
    }

    public static MockResponse response201() {
        return new MockResponse().setResponseCode(201);
    }

    public static MockResponse response204() {
        return new MockResponse().setResponseCode(204);
    }

    public static MockResponse response200(String body) {
        if(body == null || body.isEmpty())
            return new MockResponse().setResponseCode(200);
        return new MockResponse().setResponseCode(200).setBody(body);
    }

    public static MockResponse response404() {
        return new MockResponse().setResponseCode(404);
    }
}
