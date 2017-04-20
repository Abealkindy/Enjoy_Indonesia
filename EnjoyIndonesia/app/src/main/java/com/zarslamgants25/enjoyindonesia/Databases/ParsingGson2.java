package com.zarslamgants25.enjoyindonesia.Databases;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by KOCHOR on 4/18/2017.
 */

public class ParsingGson2 {
    @SerializedName("tb_kategori_wisata")
    public List<KumpulanKategoriWisata> kategoriWisataList;

    public class KumpulanKategoriWisata {
        @SerializedName("id_kategori_wisata")
        public String id_kategori_wisata;
        @SerializedName("nama_kategori_wisata")
        public String nama_kategori_wisata;
        @SerializedName("gambar_kategori_wisata")
        public String gambar_kategori_wisata;
    }
}
