package com.charmingwong.query.entity;

/**
 * Created by 56223 on 2017/2/22.
 */

public class Net_info {

    private int Is_ntp;

    private int Ntp_port;

    private int Is_dns;

    private int Dns_port;

    private int Is_proxy;

    private int Proxy_port;

    private int Is_vpn;

    private int Vpn_port;

    public void setIs_ntp(int Is_ntp){
        this.Is_ntp = Is_ntp;
    }
    public int getIs_ntp(){
        return this.Is_ntp;
    }
    public void setNtp_port(int Ntp_port){
        this.Ntp_port = Ntp_port;
    }
    public int getNtp_port(){
        return this.Ntp_port;
    }
    public void setIs_dns(int Is_dns){
        this.Is_dns = Is_dns;
    }
    public int getIs_dns(){
        return this.Is_dns;
    }
    public void setDns_port(int Dns_port){
        this.Dns_port = Dns_port;
    }
    public int getDns_port(){
        return this.Dns_port;
    }
    public void setIs_proxy(int Is_proxy){
        this.Is_proxy = Is_proxy;
    }
    public int getIs_proxy(){
        return this.Is_proxy;
    }
    public void setProxy_port(int Proxy_port){
        this.Proxy_port = Proxy_port;
    }
    public int getProxy_port(){
        return this.Proxy_port;
    }
    public void setIs_vpn(int Is_vpn){
        this.Is_vpn = Is_vpn;
    }
    public int getIs_vpn(){
        return this.Is_vpn;
    }
    public void setVpn_port(int Vpn_port){
        this.Vpn_port = Vpn_port;
    }
    public int getVpn_port(){
        return this.Vpn_port;
    }
}
