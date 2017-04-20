package com.zarslamgants25.enjoyindonesia.Databases;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by KOCHOR on 4/19/2017.
 */

public class ParsingGson3 {
    @SerializedName("hasil")
    public List<KumpulanKota>kumpulanKotas;

    public class KumpulanKota {
        @SerializedName("id_kota_kabupaten")
        public String id_kota_kabupaten;
        @SerializedName("nama_kota_kabupaten")
        public String nama_kota_kabupaten;
        @SerializedName("gambar_kota_kabupaten")
        public String gambar_kota_kabupaten;
    }
}
