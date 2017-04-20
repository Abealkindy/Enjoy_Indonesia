package com.zarslamgants25.enjoyindonesia.Category;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Response;
import com.bumptech.glide.Glide;
import com.zarslamgants25.enjoyindonesia.ChooseLocation.WisataActivity;
import com.zarslamgants25.enjoyindonesia.Databases.KumpulanUrl;
import com.zarslamgants25.enjoyindonesia.Databases.ParsingGson2;
import com.zarslamgants25.enjoyindonesia.R;

import java.util.List;

/**
 * Created by KOCHOR on 4/18/2017.
 */

class AdapterKategoriWisata extends RecyclerView.Adapter<AdapterKategoriWisata.ViewHolder> {
    Context context;
    public List<ParsingGson2.KumpulanKategoriWisata> kategoriWisatas;
    String lemoar;

    public AdapterKategoriWisata(Category listener, List<ParsingGson2.KumpulanKategoriWisata> kategoriWisataList, String lempar) {
        context = listener;
        kategoriWisatas = kategoriWisataList;
        lemoar = lempar;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_kategori, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.textNamaKategori.setText(kategoriWisatas.get(position).nama_kategori_wisata);
        Glide.with(context)
                .load(KumpulanUrl.URL_GAMBAR + kategoriWisatas.get(position).gambar_kategori_wisata)
                .crossFade()
                .placeholder(R.drawable.ic_photo_size_select_actual_black_24dp)
                .into(holder.imageKategori);

        holder.cardKategori.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(v.getContext(), WisataActivity.class);
          //      Intent b = new Intent()
           //     String aaa = a.getStringExtra("id_kota_kabupatens");
          //      a.putExtra("id_kota_kabupaten_1",aaa);
                a.putExtra("id_kota_kabupaten_1",lemoar);
                a.putExtra("id_kategori_wisata", kategoriWisatas.get(position).id_kategori_wisata);
                v.getContext().startActivity(a);
            }
        });


    }

    @Override
    public int getItemCount() {
        return kategoriWisatas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textNamaKategori;
        ImageView imageKategori;
        CardView cardKategori;

        public ViewHolder(View itemView) {
            super(itemView);
            cardKategori = (CardView) itemView.findViewById(R.id.card_kategori);
            imageKategori = (ImageView) itemView.findViewById(R.id.gambar_kategori);
            textNamaKategori = (TextView) itemView.findViewById(R.id.nama_kategori);
        }
    }
}
