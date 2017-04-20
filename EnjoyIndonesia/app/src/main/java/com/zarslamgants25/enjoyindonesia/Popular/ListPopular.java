package com.zarslamgants25.enjoyindonesia.Popular;

import android.widget.ImageView;

/**
 * Created by WIN10 on 23/03/2017.
 */

public class ListPopular {
    private String namaWisata;
    private String lokasiWisata;
    private String jenisWisata;

    private ImageView imgWisata;

    public ListPopular(String namaWisata, String lokasiWisata, String jenisWisata, ImageView imgWisata) {
        this.namaWisata = namaWisata;
        this.lokasiWisata = lokasiWisata;
        this.jenisWisata = jenisWisata;
        this.imgWisata = imgWisata;
    }

    public String getNamaWisata() {
        return namaWisata;
    }

    public String getLokasiWisata() {
        return lokasiWisata;
    }

    public String getJenisWisata() {
        return jenisWisata;
    }

    public ImageView getImgWisata() {
        return imgWisata;
    }
}
