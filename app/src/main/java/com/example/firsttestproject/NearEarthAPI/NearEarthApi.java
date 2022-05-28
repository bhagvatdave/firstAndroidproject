package com.example.firsttestproject.NearEarthAPI;

import com.example.firsttestproject.NearEarthAPI.Class.Nasa;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NearEarthApi {

    @GET("neo/rest/v1/feed")
    Call<Nasa> getdata(@Query("api_key")String Apikey);

}
