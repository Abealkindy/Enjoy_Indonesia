package com.zarslamgants25.enjoyindonesia.ChooseLocation;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.zarslamgants25.enjoyindonesia.Databases.ParsingGson1;
import com.zarslamgants25.enjoyindonesia.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ChooseLocation extends Fragment {
    RecyclerView recylerViewProvinsi;
    RequestQueue queue;
    StringRequest stringRequest;
    KumpulanUrl kumpulanUrl;
    ParsingGson1 parsingGson1;

    public ChooseLocation() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_choose_location, container, false);

        recylerViewProvinsi = (RecyclerView) view.findViewById(R.id.recycler_provinsi);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recylerViewProvinsi.setLayoutManager(linearLayoutManager);

        String aa = (KumpulanUrl.URL_PROVINSI);

        queue = Volley.newRequestQueue(getActivity());

        stringRequest = new StringRequest(Request.Method.POST, aa, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("response", response);
                try {


                    GsonBuilder builder = new GsonBuilder();
                    Gson gson1 = builder.create();
                    parsingGson1 = gson1.fromJson(response, ParsingGson1.class);
                    AdapterChooseLocation location = new AdapterChooseLocation(getActivity(), parsingGson1.dataProvinsis);
                    recylerViewProvinsi.setAdapter(location);
                } catch (NullPointerException e) {
                    Toast.makeText(getActivity(), "Maaf Konten Masih Kosong ", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(), "Maaf Internet Lambat", Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(stringRequest);

        // Inflate the layout for this fragment
        return view;
    }

}
