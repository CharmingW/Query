package com.charmingwong.query.entity;

/**
 * Created by 56223 on 2017/2/22.
 */

public class DomainRoot {

    /**
     * status : true
     * available : false
     */

    private boolean status;
    private boolean available;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
