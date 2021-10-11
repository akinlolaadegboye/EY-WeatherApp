package com.ey.veiwModels;

import android.util.Log;
import com.ey.models.CityWeatherModel;
import com.ey.models.WeatherPojos.Weather;
import com.ey.models.WeatherPojos.WeatherPojo;
import com.ey.service.ApiClient;
import com.ey.service.ApiInterface;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CityWeatherViewModel extends ViewModel{
    private MutableLiveData<CityWeatherModel> weatherModelMutableLiveData;
    private MutableLiveData<Boolean> isLoadingMutableLiveData;

    public CityWeatherViewModel(){
        weatherModelMutableLiveData = new MutableLiveData<>();
        isLoadingMutableLiveData = new MutableLiveData<>();
    }

    public MutableLiveData<CityWeatherModel> getCityWeatherObserver(){
        return weatherModelMutableLiveData;
    }

    public MutableLiveData<Boolean> getIsLoadingMutableLiveData(){
        return isLoadingMutableLiveData;
    }

    public  void fetchCityWeather(String city, String apiKey) {
        isLoadingMutableLiveData.postValue(true);
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<WeatherPojo> call = apiService.fetchCityWeather(city,apiKey);
        call.enqueue(new Callback<WeatherPojo>() {
            @Override
            public void onResponse(Call<WeatherPojo> call, Response<WeatherPojo> response) {
                WeatherPojo weatherResponse = response.body();
                WeatherPojo weatherPojo = weatherResponse;
                if (response.isSuccessful() && null != weatherPojo) {
                        Weather[] weatherMainSubContents = weatherPojo.getWeather();
                        CityWeatherModel cityWeatherObject = new CityWeatherModel(
                                weatherMainSubContents[0].getID(),
                                weatherMainSubContents[0].getMain(),
                                weatherMainSubContents[0].getDescription(),
                                weatherPojo.getMain().getTemp(),
                                weatherPojo.getMain().getTempMax(),
                                weatherPojo.getMain().getTempMin(),
                                weatherPojo.getMain().getPressure(),
                                weatherPojo.getMain().getHumidity(),
                                weatherPojo.getMain().getSeaLevel(),
                                weatherPojo.getWind().getSpeed(),
                                weatherPojo.getWind().getDeg(),
                                weatherPojo.getWind().getGust(),
                                weatherPojo.getSys().getSunrise(),
                                weatherPojo.getSys().getSunset(),
                                weatherPojo.getSys().getCountry()
                        );
                    weatherModelMutableLiveData.setValue(cityWeatherObject);
                    isLoadingMutableLiveData.setValue(false);
                } else if (response.isSuccessful() && null == weatherPojo) {
                    weatherModelMutableLiveData.setValue(null);
                    isLoadingMutableLiveData.setValue(false);
                }
            }

            @Override
            public void onFailure(Call<WeatherPojo> call, Throwable t) {
                weatherModelMutableLiveData.setValue(null);
                isLoadingMutableLiveData.setValue(false);
            }
        });
    }
}
