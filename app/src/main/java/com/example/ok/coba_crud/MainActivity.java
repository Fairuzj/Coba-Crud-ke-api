package com.example.ok.coba_crud;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.example.ok.coba_crud.PadiAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    Button btIns;
    ApiInterface mApiInterface;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
//    PadiAdapter padiAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static MainActivity ma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btIns = (Button) findViewById(R.id.btIns);
        btIns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, InsertActivity.class));
            }
        });
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        ma=this;
        refresh();
    }

    public void refresh() {
        Call<GetPadi> padiCall = mApiInterface.getPadi();
        padiCall.enqueue(new Callback<GetPadi>() {
            @Override
            public void onResponse(Call<GetPadi> call, Response<GetPadi>
                    response) {
                List<Padi> PadiList = response.body().getListPadi();
                Log.d("Retrofit Get", "Jumlah data Padi: " +
                        String.valueOf(PadiList.size()));
                mAdapter = new PadiAdapter(PadiList);
                mRecyclerView.setAdapter(mAdapter);


            }


            @Override
            public void onFailure(Call<GetPadi> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }
}