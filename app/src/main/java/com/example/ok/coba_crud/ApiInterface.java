package com.example.ok.coba_crud;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface ApiInterface {
    @GET("padi")
    Call<GetPadi> getPadi();

    @FormUrlEncoded
    @POST("insert")
    Call<CRUDPadi> postPadi(@Field("luas_lahan") Integer luas_lahan,
                                        @Field("tgl_tanam") String tgl_tanam,
                                        @Field("tgl_siap_panen") String tgl_siap_panen,
                                        @Field("hasil_panen") String hasil_panen,
                                        @Field("pemilik") String pemilik,
                                        @Field("nik") Integer nik,
                                        @Field("pekerja") Integer pekerja
    );
    @FormUrlEncoded
    @PUT("updatepadi")
    Call<CRUDPadi> putPadi(@Field("id") Integer id,
                           @Field("tgl_tanam") Integer luas_lahan,
                           @Field("tgl_tanam") String tgl_tanam,
                           @Field("tgl_siap_panen") String tgl_siap_panen,
                           @Field("hasil_panen") String hasil_panen,
                           @Field("pemilik") String pemilik,
                           @Field("nik") Integer nik,
                           @Field("pekerja") Integer pekerja);
    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "deletepadi", hasBody = true)
    Call<CRUDPadi> deletePadi(@Field("id") String id);
}