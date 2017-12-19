package com.example.admin.abcfashions.WebService.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by admin on 12/17/17.
 */

public class Marker {

    @SerializedName("Name")
    @Expose

    private String name;
    @SerializedName("Lat")
    @Expose
    private String lat;

    @SerializedName("Long")
    @Expose

    private String lng;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }
}
