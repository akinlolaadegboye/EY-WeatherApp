package com.ey.service;
import com.ey.models.WeatherPojos.WeatherPojo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("2.5/weather")
    Call<WeatherPojo> fetchCityWeather(
            @Query("q") String city,
            @Query("apiKey") String apiKey
    );
}
