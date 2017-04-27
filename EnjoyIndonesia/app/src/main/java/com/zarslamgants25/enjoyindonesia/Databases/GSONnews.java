package com.zarslamgants25.enjoyindonesia.Databases;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by WIN10 on 17/04/2017.
 */

public class GSONnews {
    @SerializedName("hasil")
    public List<KumpulanBerita>kumpulanBeritas;


    public class KumpulanBerita {
        @SerializedName("id_news")
        public String id_news;
        @SerializedName("judul_news")
        public String judul_news;
        @SerializedName("url_gambar")
        public String url_gambar;
    }
}
