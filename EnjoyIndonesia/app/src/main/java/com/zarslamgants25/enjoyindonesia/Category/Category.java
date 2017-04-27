package com.zarslamgants25.enjoyindonesia.Category;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
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
import com.zarslamgants25.enjoyindonesia.Databases.ParsingGson2;
import com.zarslamgants25.enjoyindonesia.R;

public class Category extends AppCompatActivity {

    RecyclerView recyclerViewKategori;
    RequestQueue queueKoategori;
    StringRequest stringRequestKategori;
    ParsingGson2 parsingGson2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        recyclerViewKategori = (RecyclerView) findViewById(R.id.recycler_category);
        GridLayoutManager grid = new GridLayoutManager(this, 2);
        recyclerViewKategori.setLayoutManager(grid);

        final String lempar = getIntent().getStringExtra("id_kota_kabupatens");

        String aaa = (KumpulanUrl.URL_KATEGORI_WISATA);
        queueKoategori = Volley.newRequestQueue(this);
        stringRequestKategori = new StringRequest(Request.Method.POST, aaa, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("responses", response);
                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson2 = gsonBuilder.create();
                parsingGson2 = gson2.fromJson(response, ParsingGson2.class);
                AdapterKategoriWisata wisata = new AdapterKategoriWisata(Category.this, parsingGson2.kategoriWisataList, lempar);
                recyclerViewKategori.setAdapter(wisata);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Category.this, "Maaf Internet Lambat", Toast.LENGTH_SHORT).show();
            }
        });
        queueKoategori.add(stringRequestKategori);


    }
}
