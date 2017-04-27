package com.zarslamgants25.enjoyindonesia.ChooseLocation;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zarslamgants25.enjoyindonesia.Databases.KumpulanUrl;
import com.zarslamgants25.enjoyindonesia.Databases.ParsingGson4;
import com.zarslamgants25.enjoyindonesia.R;

public class WisataActivity extends AppCompatActivity {

    RequestQueue queueWisata;
    StringRequest stringRequestWisata;
    RecyclerView recyclerViewWisata;
    ParsingGson4 parsingGson4;
    SwipeRefreshLayout refreshWisata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wisata);

        recyclerViewWisata = (RecyclerView) findViewById(R.id.recycler_wisata);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerViewWisata.setLayoutManager(llm);

        refreshWisata = (SwipeRefreshLayout)findViewById(R.id.swipewisata);

        refreshWisata.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
            refreshWisata.setRefreshing(false);

                Proses();

            }
        });

Proses();

    }

    private void  Proses (){
        queueWisata = Volley.newRequestQueue(this);

        String tangkap_id_kota_kabupaten = getIntent().getStringExtra("id_kota_kabupaten_1");
        String tangkap_id_kategori_wisata = getIntent().getStringExtra("id_kategori_wisata");

        String url = "http://31.220.53.18/muhammadabidzar/server_lomba/list_wisata.php?id_kota_kabupaten=" + tangkap_id_kota_kabupaten + "&id_kategori_wisata=" + tangkap_id_kategori_wisata;
     //     String url = (KumpulanUrl.URL_WISATA);
        Log.d("url",url);
        stringRequestWisata = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("responsess", response);
                try {

                    GsonBuilder builder = new GsonBuilder();
                    Gson gson242 = builder.create();
                    parsingGson4 = gson242.fromJson(response, ParsingGson4.class);
                    AdapterWisata wisata = new AdapterWisata(WisataActivity.this, parsingGson4.daftarWisatas);
                    recyclerViewWisata.setAdapter(wisata);
                } catch (NullPointerException e) {
                    Toast.makeText(WisataActivity.this, "aagagagag", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(WisataActivity.this, "ahagaga", Toast.LENGTH_SHORT).show();
            }
        });
        queueWisata.add(stringRequestWisata);

    }
}
