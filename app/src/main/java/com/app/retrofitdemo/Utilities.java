package com.app.retrofitdemo;

import com.app.retrofitdemo.repository.DepRepository;

public class Utilities {

    private Utilities() {
    }

//    public static final String API_URL = "http://localhost:8080/api/";
    public static final String API_URL = "http://192.168.8.101:8080/api/departements/";

    public static DepRepository getDepService() {
        return RetrofitClient.getClient(API_URL).create(DepRepository.class);
    }
}
