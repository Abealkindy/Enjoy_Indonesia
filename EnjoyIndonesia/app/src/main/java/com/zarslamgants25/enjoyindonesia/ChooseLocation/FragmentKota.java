package com.zarslamgants25.enjoyindonesia.ChooseLocation;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zarslamgants25.enjoyindonesia.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentKota extends Fragment {


    public FragmentKota() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fragment_kota, container, false);
        // Inflate the layout for this fragment
        return v;
    }

}
