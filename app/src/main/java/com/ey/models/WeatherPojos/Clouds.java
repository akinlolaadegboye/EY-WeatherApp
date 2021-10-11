package com.ey.models.WeatherPojos;

import com.google.gson.annotations.SerializedName;

public class Clouds {
    private long all;

    @SerializedName("all")
    public long getAll() { return all; }
    @SerializedName("all")
    public void setAll(long value) { this.all = value; }
}
