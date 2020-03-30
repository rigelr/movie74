package com.rigelr.watchedmovie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class AboutActivity extends AppCompatActivity {

    String number = "08159324414" ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
    }

    public void handleInfo(View view) {
        Intent call = new Intent(Intent. ACTION_DIAL);
        call.setData(Uri. fromParts("tel",number,null));
        startActivity(call);
    }

    public void handleSaran(View view) {
        Intent message = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms",number,null));
        message.putExtra("sms_body","Halo saya ingin memberi sebuah saran \t");
        startActivity(message);
    }
}
