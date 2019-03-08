package com.example.ok.coba_crud;

import com.google.gson.annotations.SerializedName;


public class Padi {
    @SerializedName("id")
    private Integer id;
    @SerializedName("luas_lahan")
    private Integer luas_lahan;
    @SerializedName("tgl_tanam")
    private String tgl_tanam;
    @SerializedName("tgl_siap_panen")
    private String tgl_siap_panen;
    @SerializedName("hasil_panen")
    private String hasil_panen;
    @SerializedName("pemilik")
    private String pemilik;
    @SerializedName("nik")
    private Integer nik;
    @SerializedName("pekerja")
    private Integer pekerja;

    public Padi(){}

    public Padi(Integer id, Integer luas_lahan, String tgl_tanam, String tgl_siap_panen, String hasil_panen, String pemilik, Integer nik, Integer pekerja) {
        this.id = id;
        this.luas_lahan = luas_lahan;
        this.tgl_tanam = tgl_tanam;
        this.tgl_siap_panen = tgl_siap_panen;
        this.hasil_panen = hasil_panen;
        this.pemilik = pemilik;
        this.nik = nik;
        this.pekerja = pekerja;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLuas_lahan() {
        return luas_lahan;
    }

    public void setLuas_lahan(Integer luas_lahan) {
        this.luas_lahan = luas_lahan;
    }

    public String getTgl_tanam() {
        return tgl_tanam;
    }

    public void setTgl_tanam(String tgl_tanam) {
        this.tgl_tanam = tgl_tanam;
    }

    public String getTgl_siap_panen() {
        return tgl_siap_panen;
    }

    public void setTgl_siap_panen(String tgl_siap_panen) {
        this.tgl_siap_panen = tgl_siap_panen;
    }

    public String getHasil_panen() {
        return hasil_panen;
    }

    public void setHasil_panen(String hasil_panen) {
        this.hasil_panen = hasil_panen;
    }

    public String getPemilik() {
        return pemilik;
    }

    public void setPemilik(String pemilik) {
        this.pemilik = pemilik;
    }

    public Integer getNik() {
        return nik;
    }

    public void setNik(Integer nik) {
        this.nik = nik;
    }

    public Integer getPekerja() {
        return pekerja;
    }

    public void setPekerja(Integer pekerja) {
        this.pekerja = pekerja;
    }
}