package com.example.ok.coba_crud;
import com.google.gson.annotations.SerializedName;

/**
 * Created by root on 2/3/17.
 */

public class CRUDPadi {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    Padi mPadi;
    @SerializedName("message")
    String message;
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Padi getPadi() {
        return mPadi;
    }
    public void setPadi(Padi Padi) {
        mPadi = Padi;
    }

}