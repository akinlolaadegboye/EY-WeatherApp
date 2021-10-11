package com.ey.models.WeatherPojos;

import com.google.gson.annotations.SerializedName;

public class Coord {
    private double lon;
    private double lat;

    @SerializedName("lon")
    public double getLon() { return lon; }
    @SerializedName("lon")
    public void setLon(double value) { this.lon = value; }

    @SerializedName("lat")
    public double getLat() { return lat; }
    @SerializedName("lat")
    public void setLat(double value) { this.lat = value; }
}
