package com.ey.models.WeatherPojos;

import com.google.gson.annotations.SerializedName;

public class Main {
    private double temp;
    private double feelsLike;
    private double tempMin;
    private double tempMax;
    private long pressure;
    private long humidity;
    private long seaLevel;
    private long grndLevel;

    @SerializedName("temp")
    public double getTemp() { return temp; }
    @SerializedName("temp")
    public void setTemp(double value) { this.temp = value; }

    @SerializedName("feels_like")
    public double getFeelsLike() { return feelsLike; }
    @SerializedName("feels_like")
    public void setFeelsLike(double value) { this.feelsLike = value; }

    @SerializedName("temp_min")
    public double getTempMin() { return tempMin; }
    @SerializedName("temp_min")
    public void setTempMin(double value) { this.tempMin = value; }

    @SerializedName("temp_max")
    public double getTempMax() { return tempMax; }
    @SerializedName("temp_max")
    public void setTempMax(double value) { this.tempMax = value; }

    @SerializedName("pressure")
    public long getPressure() { return pressure; }
    @SerializedName("pressure")
    public void setPressure(long value) { this.pressure = value; }

    @SerializedName("humidity")
    public long getHumidity() { return humidity; }
    @SerializedName("humidity")
    public void setHumidity(long value) { this.humidity = value; }

    @SerializedName("sea_level")
    public long getSeaLevel() { return seaLevel; }
    @SerializedName("sea_level")
    public void setSeaLevel(long value) { this.seaLevel = value; }

    @SerializedName("grnd_level")
    public long getGrndLevel() { return grndLevel; }
    @SerializedName("grnd_level")
    public void setGrndLevel(long value) { this.grndLevel = value; }
}
