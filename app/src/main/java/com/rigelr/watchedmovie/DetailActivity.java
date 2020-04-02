package com.rigelr.watchedmovie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.rigelr.watchedmovie.models.Movie;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_DATA_MOVIE = "EXTRA_DATA_MOVIE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().setTitle("Detail Activity");

        if (getIntent().hasExtra(EXTRA_DATA_MOVIE)) {
            Movie movie = getIntent().getParcelableExtra(EXTRA_DATA_MOVIE);

            Toast.makeText(this, movie.getName(), Toast.LENGTH_SHORT)
                    .show();
        }
    }
}
