package com.rigelr.watchedmovie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AboutActivity extends AppCompatActivity {

    String number = "08159324414" ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
    }

    public void handleInfo(View view) {
        Intent request = new Intent(this, RequestActivity.class);
        startActivity(request);

    }

    public void handleSaran(View view) {
        Intent call = new Intent(Intent. ACTION_DIAL);
        call.setData(Uri. fromParts("tel",number,null));
        startActivity(call);
    }
}
