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
import com.zarslamgants25.enjoyindonesia.Category.Category;
import com.zarslamgants25.enjoyindonesia.Databases.KumpulanUrl;
import com.zarslamgants25.enjoyindonesia.Databases.ParsingGson3;
import com.zarslamgants25.enjoyindonesia.R;

import java.util.List;

/**
 * Created by KOCHOR on 4/19/2017.
 */

class AdapterKota extends RecyclerView.Adapter<AdapterKota.ViewHolder> {

    Context contextnn;
    public List<ParsingGson3.KumpulanKota>kumpulanKotas2;
    public AdapterKota(KotaActivity kotaActivity, List<ParsingGson3.KumpulanKota> kumpulanKotas) {

        contextnn = kotaActivity;
        kumpulanKotas2 = kumpulanKotas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_kota,parent,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.textKota.setText(kumpulanKotas2.get(position).nama_kota_kabupaten);
        Glide.with(contextnn)
                .load(KumpulanUrl.URL_GAMBAR + kumpulanKotas2.get(position).gambar_kota_kabupaten)
                .crossFade()
                .placeholder(R.drawable.ic_photo_size_select_actual_black_24dp)
                .into(holder.imageKota);
        holder.cardKota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b = new Intent(v.getContext(),Category.class);

                b.putExtra("id_kota_kabupatens",kumpulanKotas2.get(position).id_kota_kabupaten);
                v.getContext().startActivity(b);
            }
        });



    }

    @Override
    public int getItemCount() {
        return kumpulanKotas2.size();
    }
    protected class ViewHolder extends RecyclerView.ViewHolder{

        TextView textKota;
        ImageView imageKota;
        CardView cardKota;
        protected ViewHolder(View itemView) {
            super(itemView);
            textKota = (TextView)itemView.findViewById(R.id.nama_kota);
            imageKota = (ImageView)itemView.findViewById(R.id.gambarkota);
            cardKota = (CardView)itemView.findViewById(R.id.card_kota);

        }
    }
}
