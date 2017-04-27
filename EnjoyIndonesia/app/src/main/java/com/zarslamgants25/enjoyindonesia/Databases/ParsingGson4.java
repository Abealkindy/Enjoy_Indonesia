package com.zarslamgants25.enjoyindonesia.Databases;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by KOCHOR on 4/19/2017.
 */

public class ParsingGson4 {
    @SerializedName("hasil")
    public List<DaftarWisata> daftarWisatas;

    public class DaftarWisata {
        @SerializedName("id_wisata")
        public String id_wisata;
        @SerializedName("judul_wisata")
        public String judul_wisata;
        @SerializedName("url_gambar")
        public String url_gambar;
        @SerializedName("nama_kota_kabupaten")
        public String id_kota_kabupaten;
        @SerializedName("nama_kategori_wisata")
        public String id_kategori_wisata;
//        @SerializedName("popular_wisata")
//        public String popular_wisata;
//        @SerializedName("id_popular")
//        public String id_popular;

    }
}
