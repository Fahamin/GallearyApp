package com.fahamin.gallearyapp.api;

public class ApiUtils {
    private ApiUtils() {
    }

    public static final String BASE_URL = "https://api.unsplash.com/";

    public static API getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(API.class);
    }

}
