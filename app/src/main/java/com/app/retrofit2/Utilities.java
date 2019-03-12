package com.app.retrofit2;

import com.app.retrofit2.repository.DepRepository;

public class Utilities {

    private Utilities() {
    }

    public static final String API_URL = "http://localhost:8080/api/";

    public static DepRepository getUserService() {
        return RetrofitClient.getClient(API_URL).create(DepRepository.class);
    }
}
