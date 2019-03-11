package com.example.ok.coba_crud;

import android.app.ProgressDialog;
import android.os.AsyncTask;
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
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import com.example.ok.coba_crud.PadiAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    /**
     * RecyclerView = menyimpan sebanyak mungkin tampilan item yang muat di layar
     * Dan juga Hanya menggunakan tampilan dalam jumlah terbatas yang digunakan kembali saat tampilan tersebut tidak tampak di layar.
     *
     * Intinya digunakan untuk menyimpan item ke tampilan
     * **/
    RecyclerView recyclerView;
    /**
     * Repository   =   Tempatnya menyimpan Fungsion2 buat database(Table user)
     * */
    private String TAG = MainActivity.class.getSimpleName();

    private ProgressDialog pDialog;
    private ListView lv;
    private Button btins;

    //public static Pertanian_Detailpadi ma;

    // URL to get contacts JSON
    private static String url = "http://192.168.0.158:5000/padi";

    ArrayList<HashMap<String, String>> contactList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contactList = new ArrayList<>();
        btins = (Button) findViewById(R.id.btIns);
        btins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, InsertActivity.class));
            }
        });

        lv = (ListView) findViewById(R.id.list);

        new GetContacts().execute();
    }

    /**
     * Async task class to get json by making HTTP call
     */
    private class GetContacts extends AsyncTask<Void, Void, Void> {
        //
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(MainActivity.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();

            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(url);

            Log.e(TAG, "Response from url: " + jsonStr);

            if (jsonStr != null) {
                try {
                    JSONArray contacts = new JSONArray(jsonStr);
                    // looping through All Contacts
                    for (int i = 0; i < contacts.length(); i++) {
                        JSONObject c = contacts.getJSONObject(i);

                        String id               = c.getString("id");
                        String luas_lahan       = c.getString("luas_lahan");
                        String tgl_tanam        = c.getString("tgl_tanam");
                        String tgl_siap_panen   = c.getString("tgl_siap_panen");
                        String hasil_panen      = c.getString("hasil_panen");
                        String pemilik          = c.getString("pemilik");
                        String nik              = c.getString("nik");
                        String pekerja          = c.getString("pekerja");
                        // tmp hash map for single contact
                        HashMap<String, String> contact = new HashMap<>();

                        // adding each child node to HashMap key => value
                        contact.put("luas_lahan", luas_lahan);
                        contact.put("id", id);
                        contact.put("tgl_tanam", tgl_tanam);
                        contact.put("tgl_siap_panen", tgl_siap_panen);
                        contact.put("hasil_panen", hasil_panen);
                        contact.put("pemilik", pemilik);
                        contact.put("nik", nik);
                        contact.put("pekerja", pekerja);

                        // adding contact to contact list
                        contactList.add(contact);
                    }
                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Json parsing error: " + e.getMessage(),
                                    Toast.LENGTH_LONG)
                                    .show();
                        }
                    });

                }
            } else {
                Log.e(TAG, "Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Couldn't get json from server. Check LogCat for possible errors!",
                                Toast.LENGTH_LONG)
                                .show();
                    }
                });

            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();
            /**
             * Updating parsed JSON data into ListView
             * */
            ListAdapter adapter = new SimpleAdapter(
                    MainActivity.this, contactList,
                    R.layout.padi_list, new String[]{"id", "luas_lahan",
                    "tgl_tanam","tgl_siap_panen","hasil_panen","pemilik","nik","pekerja"},
                    new int[]{R.id.tvId,
                            R.id.tvLuas, R.id.tvTglTanam,R.id.tvTglPanen,R.id.tvHasil,R.id.tvPemilik,R.id.tvNik,
                            R.id.tvPekerja});

            lv.setAdapter(adapter);
        }

    }
    /**
     *  Function yang digunakan untuk menambahkan data
     * */
    public void addNewItem(View view) {
        /**
         *  Tujuan perpindahan halaman
         * */
        Intent intent = new Intent(this,InsertActivity.class);
        /**
         *  Akan mengirimkan Tambahan data yang akan di terima berdasarkan Namenya
         * */
        intent.putExtra("create",true);
        startActivity(intent);
    }
}
