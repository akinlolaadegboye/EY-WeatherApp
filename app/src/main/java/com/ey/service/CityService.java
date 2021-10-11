package com.ey.service;
import com.ey.models.CityModel;
import com.ey.models.CityWeatherModel;
import com.ey.models.WeatherPojos.Weather;
import com.ey.models.WeatherPojos.WeatherPojo;
import com.ey.utils.Constants;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CityService {
    public static  List<CityModel> fetchCityList(){
        List<CityModel> cityModelList = new ArrayList<CityModel>();
        for(int i = 0; i < Constants.CITY_NAME_ARRAY.length; i++ ){
            cityModelList.add(new CityModel(Constants.CITY_NAME_ARRAY[i]));
        }
        return cityModelList;
    }
}
