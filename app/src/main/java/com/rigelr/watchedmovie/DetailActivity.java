package com.rigelr.watchedmovie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.rigelr.watchedmovie.models.Movie;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_DATA_MOVIE = "EXTRA_DATA_MOVIE";
    private TextView TVtitle;
    private  TextView TVdesc;
    private ImageView IVposter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().setTitle("Detail Activity");
        TVtitle = findViewById(R.id.txt_title);
        TVdesc = findViewById(R.id.txt_desc);
        IVposter = findViewById(R.id.imageView3);

        if (getIntent().hasExtra(EXTRA_DATA_MOVIE)) {
            Movie movie = getIntent().getParcelableExtra(EXTRA_DATA_MOVIE);
            Glide.with(this)
                    .load(movie.getPhoto())
                    .apply(new RequestOptions().override(350, 550))
                    .into(IVposter);
            TVtitle.setText(movie.getName());
            TVdesc.setText(movie.getDetail());

            Toast.makeText(this, movie.getName(), Toast.LENGTH_SHORT)
                    .show();
        }
    }
}
