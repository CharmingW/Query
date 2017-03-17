package com.charmingwong.query.entity;

/**
 * Created by 56223 on 2017/2/22.
 */

public class Base_info {
    private String city;

    private String country;

    private String county;

    private String isp;

    private String province;

    public void setCity(String city){
        this.city = city;
    }
    public String getCity(){
        return this.city;
    }
    public void setCountry(String country){
        this.country = country;
    }
    public String getCountry(){
        return this.country;
    }
    public void setCounty(String county){
        this.county = county;
    }
    public String getCounty(){
        return this.county;
    }
    public void setIsp(String isp){
        this.isp = isp;
    }
    public String getIsp(){
        return this.isp;
    }
    public void setProvince(String province){
        this.province = province;
    }
    public String getProvince(){
        return this.province;
    }
}
