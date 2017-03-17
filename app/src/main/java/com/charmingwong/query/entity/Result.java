package com.charmingwong.query.entity;

/**
 * Created by 56223 on 2017/2/23.
 */

public class Result {

    private String area;

    private String sex;

    private String birthday;

    private String verify;

    public void setArea(String area){
        this.area = area;
    }
    public String getArea(){
        return this.area;
    }
    public void setSex(String sex){
        this.sex = sex;
    }
    public String getSex(){
        return this.sex;
    }
    public void setBirthday(String birthday){
        this.birthday = birthday;
    }
    public String getBirthday(){
        return this.birthday;
    }
    public void setVerify(String verify){
        this.verify = verify;
    }
    public String getVerify(){
        return this.verify;
    }

}
