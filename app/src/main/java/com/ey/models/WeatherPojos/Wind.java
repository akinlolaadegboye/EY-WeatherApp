package com.ey.models.WeatherPojos;

import com.google.gson.annotations.SerializedName;

public class Wind {
    private double speed;
    private long deg;
    private double gust;

    @SerializedName("speed")
    public double getSpeed() { return speed; }
    @SerializedName("speed")
    public void setSpeed(double value) { this.speed = value; }

    @SerializedName("deg")
    public long getDeg() { return deg; }
    @SerializedName("deg")
    public void setDeg(long value) { this.deg = value; }

    @SerializedName("gust")
    public double getGust() { return gust; }
    @SerializedName("gust")
    public void setGust(double value) { this.gust = value; }
}
