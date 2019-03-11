package com.example.ok.coba_crud;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InsertActivity extends AppCompatActivity {
    EditText edtluas_lahan, edttgl_tanam, edttgl_siap_panen, edthasil_panen, edtpemilik, edtnik, edtpekerja;
    Button btInsert, btBack;
    ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insertactivity);
        edtluas_lahan= (EditText) findViewById(R.id.edtluas);

        edttgl_tanam = (EditText) findViewById(R.id.edttgl_tanam);

        edttgl_siap_panen= (EditText) findViewById(R.id.edttgl_siap_panen);

        edthasil_panen = (EditText) findViewById(R.id.edthasil);

        edtpemilik= (EditText) findViewById(R.id.edtpemilik);

        edtnik= (EditText) findViewById(R.id.edtnik);

        edtpekerja = (EditText) findViewById(R.id.edtpekerja);

        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        btInsert = (Button) findViewById(R.id.btInserting);
        btInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<CRUDPadi> postPadiCall = mApiInterface.postPadi(
                        Integer.parseInt(String.valueOf(edtluas_lahan.getText().toString())),
                        edttgl_tanam.getText().toString(),
                        edttgl_siap_panen.getText().toString(),
                        edthasil_panen.getText().toString(),
                        edtpemilik.getText().toString(),
                        Integer.parseInt(String.valueOf(edtnik.getText().toString())),
                        Integer.parseInt(String.valueOf(edtpekerja.getText().toString()))
                        );
                postPadiCall.enqueue(new Callback<CRUDPadi>() {
                    @Override
                    public void onResponse(Call<CRUDPadi> call, Response<CRUDPadi> response) {
                        Intent intent = new Intent(InsertActivity.this,MainActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<CRUDPadi> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        btBack = (Button) findViewById(R.id.btBackGo);
        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InsertActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}