package com.zarslamgants25.enjoyindonesia.ChooseLocation;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zarslamgants25.enjoyindonesia.Databases.ParsingGson4;
import com.zarslamgants25.enjoyindonesia.R;

import java.util.List;

/**
 * Created by KOCHOR on 4/19/2017.
 */

class AdapterWisata extends RecyclerView.Adapter<AdapterWisata.ViewHolder> {

    Context context;
    public List<ParsingGson4.DaftarWisata> daftarWisatass;

    public AdapterWisata(WisataActivity wisataActivity, List<ParsingGson4.DaftarWisata> daftarWisatas) {
        context = wisataActivity;
        daftarWisatass = daftarWisatas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_popular, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.nama_wisata.setText(daftarWisatass.get(position).judul_wisata);
        holder.lokasi_wisata.setText(daftarWisatass.get(position).id_kota_kabupaten);
        holder.jenis_wisata.setText(daftarWisatass.get(position).id_kategori_wisata);
        Glide.with(context)
                .load(daftarWisatass.get(position).url_gambar)
                .crossFade()
                .placeholder(R.drawable.ic_photo_size_select_actual_black_24dp)
                .into(holder.gambar_wisata);
        holder.cardWisata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(v.getContext(),Detail_wisata.class);
                a.putExtra("id_wisata", daftarWisatass.get(position).id_wisata);
                a.putExtra("popular", daftarWisatass.get(position).popular_wisata);
                v.getContext().startActivity(a);
            }
        });

    }

    @Override
    public int getItemCount() {
        return daftarWisatass.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView nama_wisata, lokasi_wisata, jenis_wisata;
        ImageView gambar_wisata;
        CardView cardWisata;

        public ViewHolder(View itemView) {
            super(itemView);

            nama_wisata = (TextView)itemView.findViewById(R.id.tvNamaWisata);
            lokasi_wisata = (TextView)itemView.findViewById(R.id.lokasi);
            jenis_wisata = (TextView)itemView.findViewById(R.id.jenis_wisata);
            gambar_wisata = (ImageView)itemView.findViewById(R.id.image_wisata);
            cardWisata = (CardView)itemView.findViewById(R.id.card_wisata);

        }
    }
}
