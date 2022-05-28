package com.example.firsttestproject.NearEarthAPI;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NearEarthHelper {
    public static NearEarthApi getApiInstance(){
        Retrofit Retrofit = new Retrofit.Builder()
                .baseUrl("https://api.nasa.gov/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        NearEarthApi api = Retrofit.create(NearEarthApi.class);
                return api;
    }
}
