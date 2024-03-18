package com.example.nhaccuatui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        loadData();
    }

    private void loadData() {
        if(AppUtil.isNetworkAvailable(this)){
            //Có mạng kết nối
            //Load data
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    startActivities(new Intent[]{intent});
                    finish();
                }
            }, 3000);

        }else {
            Toast.makeText(this, "Network Disconnected", Toast.LENGTH_SHORT).show();
        }
    }


}