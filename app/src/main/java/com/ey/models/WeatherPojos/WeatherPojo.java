package com.ey.models.WeatherPojos;

import com.google.gson.annotations.SerializedName;

public class WeatherPojo {
    private Coord coord;
    private Weather[] weather;
    private String base;
    private Main main;
    private long visibility;
    private Wind wind;
    private Clouds clouds;
    private long dt;
    private Sys sys;
    private long timezone;
    private long id;
    private String name;
    private long cod;

    @SerializedName("coord")
    public Coord getCoord() { return coord; }

    @SerializedName("coord")
    public void setCoord(Coord value) { this.coord = value; }

    @SerializedName("weather")
    public Weather[] getWeather() { return weather; }

    @SerializedName("weather")
    public void setWeather(Weather[] value) { this.weather = value; }

    @SerializedName("base")
    public String getBase() { return base; }
    @SerializedName("base")
    public void setBase(String value) { this.base = value; }

    @SerializedName("main")
    public Main getMain() { return main; }
    @SerializedName("main")
    public void setMain(Main value) { this.main = value; }

    @SerializedName("visibility")
    public long getVisibility() { return visibility; }
    @SerializedName("visibility")
    public void setVisibility(long value) { this.visibility = value; }

    @SerializedName("wind")
    public Wind getWind() { return wind; }
    @SerializedName("wind")
    public void setWind(Wind value) { this.wind = value; }

    @SerializedName("clouds")
    public Clouds getClouds() { return clouds; }
    @SerializedName("clouds")
    public void setClouds(Clouds value) { this.clouds = value; }

    @SerializedName("dt")
    public long getDt() { return dt; }
    @SerializedName("dt")
    public void setDt(long value) { this.dt = value; }

    @SerializedName("sys")
    public Sys getSys() { return sys; }
    @SerializedName("sys")
    public void setSys(Sys value) { this.sys = value; }

    @SerializedName("timezone")
    public long getTimezone() { return timezone; }
    @SerializedName("timezone")
    public void setTimezone(long value) { this.timezone = value; }

    @SerializedName("id")
    public long getID() { return id; }
    @SerializedName("id")
    public void setID(long value) { this.id = value; }

    @SerializedName("name")
    public String getName() { return name; }
    @SerializedName("name")
    public void setName(String value) { this.name = value; }

    @SerializedName("cod")
    public long getCod() { return cod; }
    @SerializedName("cod")
    public void setCod(long value) { this.cod = value; }
}
