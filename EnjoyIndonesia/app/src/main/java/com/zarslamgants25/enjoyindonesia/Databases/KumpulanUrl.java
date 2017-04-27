package com.zarslamgants25.enjoyindonesia.Databases;

/**
 * Created by KOCHOR on 4/18/2017.
 */

public class KumpulanUrl {
    private static  String URL_SERVER = "http://31.220.53.18/muhammadabidzar/server_lomba/";
    private static  String URL_SERVER_GAMBAR = "http://31.220.53.18/muhammadabidzar/";
    public static  final String URL_PROVINSI = URL_SERVER + "output_kategori.php";
    public static  final String URL_KATEGORI_WISATA = URL_SERVER + "output_kategori_wisata.php";
    public static final String URL_KOTA = URL_SERVER + "output_kota.php?id_provinsi=";
    public static final String URL_POPULAR = URL_SERVER + "list_popular.php";
    public static final String URL_DETAIL = URL_SERVER + "detail_wisata.php?send_id_wisata=";
    public static final String URL_DETAIL_NEWS = URL_SERVER + "detail_news.php?send_id_news=";
    public static final String URL_WISATA = URL_SERVER + "list_wisata.php";
    public static final String URL_NEWS = URL_SERVER + "list_news.php";


    public static  final  String URL_GAMBAR = URL_SERVER_GAMBAR + "uplod/";

}
