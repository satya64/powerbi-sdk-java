package io.github.satya64.powerbi.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import retrofit2.Response;

import java.io.IOException;

/**
 * Wrapper Class for the Powerbi API exceptions
 */
@Slf4j
public class PowerBiClientException extends Exception {

    private ObjectMapper objectMapper = new ObjectMapper();

    private ErrorMessage message;

    private PowerBiClientException() {
    }

    public PowerBiClientException(Response errorResponse) {
        try {
            String err = errorResponse.errorBody().string();
            if (!err.isEmpty()) {
                readErrorMessageFromStream(err);
            } else {
                message = ErrorMessage
                        .builder()
                        .error(Error.builder()
                                .code("InvalidRequest")
                                .message("Bad data submitted")
                                .build())
                        .build();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readErrorMessageFromStream(String error) {
        try {
            message = objectMapper.readValue(error, ErrorMessage.class);
        } catch (IOException e) {
            message = ErrorMessage
                    .builder()
                    .error(Error.builder()
                            .code("UnknownError")
                            .message(e.getMessage())
                            .build())
                    .build();
        }
    }

    @Override
    public String getMessage() {
        return this.message != null ? this.message.toString() : null;
    }

    @Override
    public String toString() {
        return getMessage();
    }
}
