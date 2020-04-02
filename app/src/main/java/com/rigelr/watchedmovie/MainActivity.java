package com.rigelr.watchedmovie;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuItem;

import com.rigelr.watchedmovie.Adapters.CardViewMovieAdapter;
import com.rigelr.watchedmovie.Adapters.ListMovieAdapter;
import com.rigelr.watchedmovie.models.Movie;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvMovies;
    private ArrayList<Movie> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvMovies = findViewById(R.id.rv_movies);
        rvMovies.setHasFixedSize(true);

        list.addAll(MoviesData.getListData());
        showRecyclerList();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    private void showRecyclerList(){
        rvMovies.setLayoutManager(new LinearLayoutManager(this));
        ListMovieAdapter listMovieAdapter = new ListMovieAdapter(list);
        listMovieAdapter.setOnClicklistener(new OnClicklistener() {
            @Override
            public void handle(Movie movie) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_DATA_MOVIE,  movie);
                startActivity(intent);
            }
        });
        rvMovies.setAdapter(listMovieAdapter);
    }

    private void showRecyclerCardView(){
        rvMovies.setLayoutManager(new LinearLayoutManager(this));
        CardViewMovieAdapter cardViewHeroAdapter = new CardViewMovieAdapter(list);
        rvMovies.setAdapter(cardViewHeroAdapter);
    }

    private void About(){
        Intent intent = new Intent(this,AboutActivity.class);
        startActivity(intent);
    }




    public void setMode(int selectedMode) {
        switch (selectedMode) {
            case R.id.action_list:
                showRecyclerList();
                break;
            case R.id.action_cardview:
                showRecyclerCardView();
                break;
            case R.id.action_about:
                About();
                break;
        }
    }


}
