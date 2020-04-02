package com.rigelr.watchedmovie.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.rigelr.watchedmovie.OnClicklistener;
import com.rigelr.watchedmovie.R;
import com.rigelr.watchedmovie.models.Movie;

import java.util.ArrayList;

public class ListMovieAdapter extends RecyclerView.Adapter<ListMovieAdapter.ListViewHolder>  {
    private ArrayList<Movie> listMovie;

    private OnClicklistener onClicklistener;

    public ListMovieAdapter(ArrayList<Movie> list) {
        this.listMovie = list;
    }

    public void setOnClicklistener(OnClicklistener onClicklistener) {
        this.onClicklistener = onClicklistener;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_row_movie, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        final Movie movie = listMovie.get(position);
        Glide.with(holder.itemView.getContext())
                .load(movie.getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.imgPhoto);
        holder.tvName.setText(movie.getName());
        //holder.tvDetail.setText(movie.getDetail());


        //holder.tvName.setText(listMovie.get(position).getName().toString());

        // Set Item OnClick Listener
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClicklistener.handle(movie);
            }
        });
    }

    @Override
    public int getItemCount() {
        return (listMovie != null) ? listMovie.size() : 0;
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDetail;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            //tvDetail = itemView.findViewById(R.id.tv_item_detail);
//            Toast.makeText(holder.itemView.getContext(), "Share " +
//                    listMovie.get(holder.getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
        }
    }
}
