package com.ey.models;

public class CityWeatherModel {

    long weather_id;
    String weather_main;
    String weather_desc;

    double temp;
    double temp_max;
    double temp_min;

    double pressure;
    double humidity;
    double sea_level;

    double wind_speed;
    double wind_deg;
    double wind_gust;
    long sunrise;
    long sunset;
    String country;

    public CityWeatherModel(long weather_id,String weather_main, String weather_desc, double temp, double temp_max, double temp_min, long pressure, long humidity, long sea_level, double wind_speed, long wind_deg, double wind_gust,long sunrise,long sunset,String country) {
        this.weather_id = weather_id;
        this.weather_main = weather_main;
        this.weather_desc = weather_desc;
        this.temp = temp;
        this.temp_max = temp_max;
        this.temp_min = temp_min;
        this.pressure = pressure;
        this.humidity = humidity;
        this.sea_level = sea_level;
        this.wind_speed = wind_speed;
        this.wind_deg = wind_deg;
        this.wind_gust = wind_gust;
        this.sunrise = sunrise;
        this.sunset = sunset;
        this.country = country;
    }

    public String getWeather_main() {
        return weather_main;
    }

    public void setWeather_main(String weather_main) {
        this.weather_main = weather_main;
    }

    public String getWeather_desc() {
        return weather_desc;
    }

    public void setWeather_desc(String weather_desc) {
        this.weather_desc = weather_desc;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(double temp_max) {
        this.temp_max = temp_max;
    }

    public double getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(double temp_min) {
        this.temp_min = temp_min;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getSea_level() {
        return sea_level;
    }

    public void setSea_level(double sea_level) {
        this.sea_level = sea_level;
    }

    public double getWind_speed() {
        return wind_speed;
    }

    public void setWind_speed(double wind_speed) {
        this.wind_speed = wind_speed;
    }

    public double getWind_deg() {
        return wind_deg;
    }

    public void setWind_deg(double wind_deg) {
        this.wind_deg = wind_deg;
    }

    public double getWind_gust() {
        return wind_gust;
    }

    public void setWind_gust(double wind_gust) {
        this.wind_gust = wind_gust;
    }

    public long getWeather_id() {
        return weather_id;
    }

    public void setWeather_id(int weather_id) {
        this.weather_id = weather_id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public long getSunrise() {
        return sunrise;
    }

    public void setSunrise(int sunrise) {
        this.sunrise = sunrise;
    }

    public long getSunset() {
        return sunset;
    }

    public void setSunset(int sunset) {
        this.sunset = sunset;
    }
}
