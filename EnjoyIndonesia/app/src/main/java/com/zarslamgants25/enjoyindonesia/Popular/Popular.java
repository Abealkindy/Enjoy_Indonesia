package com.zarslamgants25.enjoyindonesia.Popular;


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
import com.zarslamgants25.enjoyindonesia.Databases.ParsingGson5;
import com.zarslamgants25.enjoyindonesia.R;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Popular extends Fragment {

    private RecyclerView recyclerViewPopular;
    RequestQueue queuePopular;
    StringRequest stringRequestPopular;
    ParsingGson5 parsingGson5;

    public Popular() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_popular, container, false);
        // Inflate the layout for this fragment

        recyclerViewPopular = (RecyclerView)view.findViewById(R.id.recycler_popular);
        recyclerViewPopular.setHasFixedSize(true);
        recyclerViewPopular.setLayoutManager(new LinearLayoutManager(getActivity()));

        queuePopular = Volley.newRequestQueue(getActivity());

        String url = (KumpulanUrl.URL_POPULAR);
        stringRequestPopular = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
            Log.d("response",response);
                GsonBuilder builder = new GsonBuilder();
                Gson gson = builder.create();
                parsingGson5 = gson.fromJson(response,ParsingGson5.class);
                AdapterPopular popular = new AdapterPopular(getActivity(), parsingGson5.dataPopulars);
                recyclerViewPopular.setAdapter(popular);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(), "gcgcsdgf", Toast.LENGTH_SHORT).show();
            }
        });
        queuePopular.add(stringRequestPopular);






        return view ;
    }

}
