package io.github.satya64.powerbi.api;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class AuthHeaderInterceptor implements Interceptor {

    private String accessToken;

    public AuthHeaderInterceptor(final String accessToken) {
        this.accessToken = accessToken;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request().newBuilder().addHeader("Authorization", "Bearer " + accessToken).build();
        return chain.proceed(request);
    }
}