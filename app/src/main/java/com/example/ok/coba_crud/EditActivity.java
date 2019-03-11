package com.example.ok.coba_crud;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditActivity extends AppCompatActivity {
    EditText editId, editluas_lahan, edittgl_tanam, edittgl_siap_panen, edithasil_panen, editpemilik, editnik, editpekerja;
    Button btUpdate, btDelete, btBack;
    ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editactivity);
        editId = (EditText) findViewById(R.id.editId);
        editluas_lahan= (EditText) findViewById(R.id.editluas);
        edittgl_tanam = (EditText) findViewById(R.id.edittgl_tanam);
        edittgl_siap_panen= (EditText) findViewById(R.id.edittgl_siap_panen);
        edithasil_panen = (EditText) findViewById(R.id.edithasil);
        editpemilik= (EditText) findViewById(R.id.editpemilik);
        editpekerja = (EditText) findViewById(R.id.editpekerja);
        Intent mIntent = getIntent();
        editId.setText(mIntent.getStringExtra("Id"));
        editId.setTag(editId.getKeyListener());
        editId.setKeyListener(null);

        editluas_lahan.setText(mIntent.getStringExtra("luas_lahan"));
        edittgl_tanam.setText(mIntent.getStringExtra("tgl_tanam"));
        edittgl_siap_panen.setText(mIntent.getStringExtra("tgl_siap_panen"));
        edithasil_panen.setText(mIntent.getStringExtra("hasil_panen"));
        editpemilik.setText(mIntent.getStringExtra("pemilik"));
        editnik.setText(mIntent.getStringExtra("nik"));
        editpekerja.setText(mIntent.getStringExtra("pekerja"));
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        btUpdate = (Button) findViewById(R.id.btUpdate2);
        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<CRUDPadi> updatePadiCall = mApiInterface.putPadi(
                        Integer.parseInt(String.valueOf(editId.getText().toString())),
                        Integer.parseInt(String.valueOf(editluas_lahan.getText().toString())),
                        edittgl_tanam.getText().toString(),
                        edittgl_siap_panen.getText().toString(),
                        edithasil_panen.getText().toString(),
                        editpemilik.getText().toString(),
                        Integer.parseInt(String.valueOf(editnik.getText().toString())),
                        Integer.parseInt(String.valueOf(editpekerja.getText().toString()))
                );
                updatePadiCall.enqueue(new Callback<CRUDPadi>() {
                    @Override
                    public void onResponse(Call<CRUDPadi> call, Response<CRUDPadi> response) {
                        Intent intent = new Intent(EditActivity.this,MainActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<CRUDPadi> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
        btDelete = (Button) findViewById(R.id.btDelete2);
        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editId.getText().toString().trim().isEmpty()==false){
                    Call<CRUDPadi> deletePadi = mApiInterface.deletePadi(editId.getText().toString());
                    deletePadi.enqueue(new Callback<CRUDPadi>() {
                        @Override
                        public void onResponse(Call<CRUDPadi> call, Response<CRUDPadi> response) {
                            Intent intent = new Intent(EditActivity.this,MainActivity.class);
                            startActivity(intent);
                        }

                        @Override
                        public void onFailure(Call<CRUDPadi> call, Throwable t) {
                            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                        }
                    });
                }else{
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                }
            }
        });
        btBack = (Button) findViewById(R.id.btBackGo);
        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}