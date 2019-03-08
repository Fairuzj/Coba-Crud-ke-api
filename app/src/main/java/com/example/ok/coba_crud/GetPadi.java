package com.example.ok.coba_crud;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by root on 2/3/17.
 */

public class GetPadi {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    List<Padi> listPadi;
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
    public List<Padi> getListPadi() {
        return listPadi;
    }
    public void setListPadi(List<Padi> listPadi) {
        this.listPadi = listPadi;
    }
}