package com.example.admin.abcfashions.Model;

/**
 * Created by admin on 12/18/17.
 */

public class Promotion {

    String name,rate,url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Promotion(String name, String rate, String url) {
        this.name = name;
        this.rate = rate;
        this.url = url;
    }
}
