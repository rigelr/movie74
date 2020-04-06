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

    String number = "08159324415" ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
    }

    public void handleRequest(View view) {
        Intent request = new Intent(this, RequestActivity.class);
        startActivity(request);

    }

    public void handleSaran(View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        // This ensures only SMS apps respond
        intent.setData(Uri.parse("smsto:"+number));
        intent.putExtra("sms_body", "Hello saya mau kasih saran buat 74 movie tentang");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
//        Intent call = new Intent(Intent. ACTION_DIAL);
//        call.setData(Uri. fromParts("tel",number,null));
//        startActivity(call);
    }
}
