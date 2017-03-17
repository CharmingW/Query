package com.charmingwong.query.entity_phone;

/**
 * Created by 56223 on 2017/2/25.
 */

public class Result {
    private String province;

    private String city;

    private String areacode;

    private String zip;

    private String company;

    private String card;

    public void setProvince(String province){
        this.province = province;
    }
    public String getProvince(){
        return this.province;
    }
    public void setCity(String city){
        this.city = city;
    }
    public String getCity(){
        return this.city;
    }
    public void setAreacode(String areacode){
        this.areacode = areacode;
    }
    public String getAreacode(){
        return this.areacode;
    }
    public void setZip(String zip){
        this.zip = zip;
    }
    public String getZip(){
        return this.zip;
    }
    public void setCompany(String company){
        this.company = company;
    }
    public String getCompany(){
        return this.company;
    }
    public void setCard(String card){
        this.card = card;
    }
    public String getCard(){
        return this.card;
    }

}