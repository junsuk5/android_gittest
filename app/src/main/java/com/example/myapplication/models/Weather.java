package com.example.myapplication.models;

public class Weather {
    private int imageRes;
    private String city;
    private String temp;

    public Weather(int imageRes, String city, String temp) {
        this.imageRes = imageRes;
        this.city = city;
        this.temp = temp;
    }

    public int getImageRes() {
        return imageRes;
    }

    public void setImageRes(int imageRes) {
        this.imageRes = imageRes;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Weather{");
        sb.append("imageRes=").append(imageRes);
        sb.append(", city='").append(city).append('\'');
        sb.append(", temp='").append(temp).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
