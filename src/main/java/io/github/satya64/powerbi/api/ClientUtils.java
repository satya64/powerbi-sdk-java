package io.github.satya64.powerbi.api;

import retrofit2.Response;

public final class ClientUtils {

    public static <T> T buildAndSendResponseBody(final Response<T> response) throws PowerBiClientException {
        if (response.isSuccessful()) return response.body();
        else throw new PowerBiClientException(response);
    }

    public static <T> int buildAndSendResponseCode(final Response<T> response) throws PowerBiClientException {
        if (response.isSuccessful())
            return response.code();
        else throw new PowerBiClientException(response);
    }

}
