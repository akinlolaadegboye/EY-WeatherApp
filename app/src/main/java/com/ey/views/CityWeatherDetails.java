package com.ey.views;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.ey.R;
import com.ey.models.CityWeatherModel;
import com.ey.utils.AppUtil;
import com.ey.utils.Constants;
import com.ey.veiwModels.CityWeatherViewModel;

import java.util.Locale;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
public class CityWeatherDetails extends AppCompatActivity {
    private CityWeatherViewModel cityWeatherViewModel;
    private CityWeatherModel cityWeatherModel;
    private LottieAnimationView lottieAnimationView;
    private AppCompatTextView tempMainTextView,humidityTextView,weatherDescTextView,cityNameTextView;
    private AppCompatTextView windTextView,windSpeedTextView,windDegreeTextView,windGustTextView;
    private AppCompatTextView sunriseTextView,sunsetTextView;
    private RelativeLayout progressLayout;
    private String cityString;
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_details);
        init();
        getIntentMethod();
        handleObservers();
        fetchCityWeather();
    }

    void getIntentMethod(){
        Intent intent = getIntent();
        cityString = intent.getStringExtra("city");
        cityNameTextView.setText(cityString);
    }

    void init(){
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(android.R.color.holo_blue_dark)));
        cityWeatherViewModel = ViewModelProviders.of(this).get(CityWeatherViewModel.class);
        progressLayout = (RelativeLayout) findViewById(R.id.progress_layout);
        tempMainTextView = (AppCompatTextView) findViewById(R.id.temp_text_view);
        humidityTextView = (AppCompatTextView) findViewById(R.id.humidity_text_view);
        windTextView = (AppCompatTextView) findViewById(R.id.wind_text_view);
        weatherDescTextView = (AppCompatTextView) findViewById(R.id.weather_description_text_view);
        windTextView = (AppCompatTextView) findViewById(R.id.wind_text_view);
        cityNameTextView = (AppCompatTextView) findViewById(R.id.city_name);

        windSpeedTextView = (AppCompatTextView) findViewById(R.id.wind_speed_text_view);
        windDegreeTextView = (AppCompatTextView) findViewById(R.id.wind_degree_text_view);
        windGustTextView = (AppCompatTextView) findViewById(R.id.wind_gust_text_view);

        sunriseTextView = (AppCompatTextView) findViewById(R.id.sunrise_text_view);
        sunsetTextView = (AppCompatTextView) findViewById(R.id.sunset_text_view);

        lottieAnimationView = (LottieAnimationView) findViewById(R.id.animation_view);
    }

    void fetchCityWeather(){
        if(AppUtil.isNetworkConnected())
            cityWeatherViewModel.fetchCityWeather(cityString, Constants.API_KEY);
        else{
            Toast.makeText(CityWeatherDetails.this, "Check your internet connection and try again.", Toast.LENGTH_LONG).show();
            finish();
        }
    }

    void setUpUi(CityWeatherModel cityWeatherModels){
        tempMainTextView.setText(String.format(Locale.getDefault(), "%.0f°", cityWeatherModel.getTemp()));
        humidityTextView.setText(String.valueOf(cityWeatherModel.getHumidity()));
        windTextView.setText(String.format(Locale.getDefault(), "%.0f km/hr", cityWeatherModel.getWind_speed()));
        windSpeedTextView.setText(String.format(Locale.getDefault(), "%.0f km/hr", cityWeatherModel.getWind_speed()));
        windGustTextView.setText(String.valueOf(cityWeatherModel.getWind_gust()));
        windDegreeTextView.setText(String.format(Locale.getDefault(), "%.0f°", cityWeatherModel.getWind_deg()));
        sunriseTextView.setText(String.valueOf(cityWeatherModel.getSunrise()));
        sunsetTextView.setText(String.valueOf(cityWeatherModel.getSunset()));
        weatherDescTextView.setText(cityWeatherModel.getWeather_desc());
        lottieAnimationView.setAnimation(AppUtil.getWeatherAnimation(Integer.parseInt(String.valueOf(cityWeatherModels.getWeather_id()))));
        lottieAnimationView.playAnimation();
    }

    void handleObservers(){
        cityWeatherViewModel.getCityWeatherObserver().observe(this, new Observer<CityWeatherModel>() {
            @Override
            public void onChanged(CityWeatherModel cityWeatherModels) {
                cityWeatherModel = cityWeatherModels;
                if(cityWeatherModel != null) {
                   setUpUi(cityWeatherModel);
                } else {
                    Toast.makeText(CityWeatherDetails.this, "Please,try again later.", Toast.LENGTH_LONG).show();
                    finish();
                }
            }
        });

        cityWeatherViewModel.getIsLoadingMutableLiveData().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean isLoading) {
                if(isLoading)
                    progressLayout.setVisibility(View.VISIBLE);
                else
                    progressLayout.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
