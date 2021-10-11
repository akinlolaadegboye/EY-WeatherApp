package com.ey.models.WeatherPojos;
import com.google.gson.annotations.SerializedName;

public class Weather {
    private long id;
    private String main;
    private String description;
    private String icon;

    @SerializedName("id")
    public long getID() { return id; }
    @SerializedName("id")
    public void setID(long value) { this.id = value; }

    @SerializedName("main")
    public String getMain() { return main; }
    @SerializedName("main")
    public void setMain(String value) { this.main = value; }

    @SerializedName("description")
    public String getDescription() { return description; }
    @SerializedName("description")
    public void setDescription(String value) { this.description = value; }

    @SerializedName("icon")
    public String getIcon() { return icon; }
    @SerializedName("icon")
    public void setIcon(String value) { this.icon = value; }
}
