package com.lqcuongnd.brafo_android_app.retrofit;

public class ApiUtils {
    //https://api.stackexchange.com/2.2/
    public static final String BASE_URL = "http://112.109.93.135:2902";

    public static SOService getSOService() {
        return RetrofitClient.getClient(BASE_URL).create(SOService.class);
    }
}