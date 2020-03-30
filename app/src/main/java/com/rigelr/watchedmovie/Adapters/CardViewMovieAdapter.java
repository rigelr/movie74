package com.rigelr.watchedmovie.Adapters;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.rigelr.watchedmovie.AboutActivity;
import com.rigelr.watchedmovie.R;
import com.rigelr.watchedmovie.models.Movie;

import java.util.ArrayList;

import static androidx.core.content.ContextCompat.startActivity;

public class CardViewMovieAdapter extends RecyclerView.Adapter<CardViewMovieAdapter.CardViewViewHolder> {
    private ArrayList<Movie> listMovie;

    String number = "08159324414" ;

    public CardViewMovieAdapter(ArrayList<Movie> listMovie) {
        this.listMovie = listMovie;
    }

    @NonNull
    @Override
    public CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview_movie, parent, false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardViewViewHolder holder, int position) {
        final Movie movie = listMovie.get(position);
        Glide.with(holder.itemView.getContext())
                .load(movie.getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhoto);
        holder.tvName.setText(movie.getName());
        holder.tvDetail.setText(movie.getDetail());
        holder.btnPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.itemView.getContext(), "pesan " +
                        listMovie.get(holder.getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(holder.itemView.getContext(), AboutActivity.class);
                Bundle b = new Bundle();
                Intent message = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms",number,null));
                message.putExtra("sms_body","Halo saya mau pesan film \t"+movie.getName()+"");

                //begin activity
                holder.itemView.getContext().startActivity(message);
            }
        });
        holder.btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.itemView.getContext(), "Share " +
                        listMovie.get(holder.getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(holder.itemView.getContext(), AboutActivity.class);
                Bundle b = new Bundle();
//                Intent message = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms",number,null));
//                message.putExtra("sms_body","Halo saya mau pesan film \t"+movie.getName()+"");

                //begin activity
                holder.itemView.getContext().startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return listMovie.size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDetail;
        Button btnPesan, btnShare;
        public CardViewViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDetail = itemView.findViewById(R.id.tv_item_detail);
            btnPesan = itemView.findViewById(R.id.btn_set_pesan);
            btnShare = itemView.findViewById(R.id.btn_set_share);
        }
    }
}
