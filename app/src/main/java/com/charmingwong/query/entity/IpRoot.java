package com.charmingwong.query.entity;

/**
 * Created by 56223 on 2017/2/22.
 */

public class IpRoot {
    private int Status;

    private String Description;

    private Base_info Base_info;

    private Net_info Net_info;

    public void setStatus(int Status){
        this.Status = Status;
    }
    public int getStatus(){
        return this.Status;
    }
    public void setDescription(String Description){
        this.Description = Description;
    }
    public String getDescription(){
        return this.Description;
    }
    public void setBase_info(Base_info Base_info){
        this.Base_info = Base_info;
    }
    public Base_info getBase_info(){
        return this.Base_info;
    }
    public void setNet_info(Net_info Net_info){
        this.Net_info = Net_info;
    }
    public Net_info getNet_info(){
        return this.Net_info;
    }

}
