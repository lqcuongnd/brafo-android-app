package com.lqcuongnd.brafo_android_app.retrofit;

import com.lqcuongnd.brafo_android_app.model.SOAnswersResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SOService {

    @GET("/orgs")
    Call<List<SOAnswersResponse>> getAnswers();

    @GET("/answers?order=desc&sort=activity&site=stackoverflow")
    Call<List<SOAnswersResponse>> getAnswers(@Query("tagged") String tags);

    @GET("/categories")
    Call<List<SOAnswersResponse>> getCategory(@Query("tagged") String tags);
}