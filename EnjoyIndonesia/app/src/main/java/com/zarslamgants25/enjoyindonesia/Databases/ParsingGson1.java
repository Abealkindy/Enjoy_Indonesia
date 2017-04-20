package com.zarslamgants25.enjoyindonesia.Databases;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by KOCHOR on 4/18/2017.
 */

public class ParsingGson1 {
    @SerializedName("tb_provinsi")
    public List<DataProvinsi>dataProvinsis;



    public class DataProvinsi {
        @SerializedName("id_provinsi")
        public String id_provinsi;
        @SerializedName("nama_provinsi")
        public String nama_provinsi;
        @SerializedName("gambar_provinsi")
        public String gambar_provinsi;
    }


}
