package com.ey.models.WeatherPojos;

import com.google.gson.annotations.SerializedName;

public class Sys {
    private String country;
    private long sunrise;
    private long sunset;

    @SerializedName("country")
    public String getCountry() { return country; }
    @SerializedName("country")
    public void setCountry(String value) { this.country = value; }

    @SerializedName("sunrise")
    public long getSunrise() { return sunrise; }
    @SerializedName("sunrise")
    public void setSunrise(long value) { this.sunrise = value; }

    @SerializedName("sunset")
    public long getSunset() { return sunset; }
    @SerializedName("sunset")
    public void setSunset(long value) { this.sunset = value; }
}
