package com.rigelr.watchedmovie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.rigelr.watchedmovie.models.Movie;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_DATA_MOVIE = "EXTRA_DATA_MOVIE";
    private TextView TVtitle;
    Movie movie;
    private  TextView TVdesc;
    private ImageView IVposter;
    String number = "08159324414" ;


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

    public void handlePesan(View view) {
        Intent intent = new Intent(this, DetailActivity.class);
        Intent message = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", number, null));
        message.putExtra("sms_body", "Halo saya mau pesan film ");

        //begin activity
        startActivity(message);
    }

    public void handleShare(View view) {
        Intent intent = new Intent(this, AboutActivity.class);
        Bundle b = new Bundle();
//                Intent message = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms",number,null));
//                message.putExtra("sms_body","Halo saya mau pesan film \t"+movie.getName()+"");
        try
        {
            // Check if the Twitter app is installed on the phone.
            getPackageManager().getPackageInfo("com.twitter.android", 0);
            Intent insstent = new Intent(Intent.ACTION_SEND);
            intent.setClassName("com.twitter.android", "com.twitter.android.composer.ComposerActivity");
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TEXT, "Your text");
            startActivity(insstent);

        }
        catch (Exception e)
        {
            Toast.makeText(this,"Twitter is not installed on this device",Toast.LENGTH_LONG).show();
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/intent/tweet?text=ayo nonton film dan beli tiket di 74Movie"));
            startActivity(browserIntent);
        }
    }
}
