package com.example.sunlight1.http;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by sunlight1 on 10/29/2017.
 */

public interface ApiInterface {



    @GET("alldata")
    Call<List<Teacherslist>> getTeacherList();

}
