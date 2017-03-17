package com.charmingwong.query.entity_phone;

/**
 * Created by 56223 on 2017/2/25.
 */

public class Root {
    private String resultcode;

    private String reason;

    private Result result;

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

    public String getResultcode() {
        return this.resultcode;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getReason() {
        return this.reason;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public Result getResult() {
        return this.result;
    }

}
