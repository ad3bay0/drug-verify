package com.ad3bay0.drugverify.activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ad3bay0.activities.R;
import com.ad3bay0.drugverify.activities.HomeActivity;

public class SplashScreenActivty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen_activty);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


                Intent intent =  new Intent(getApplicationContext(),HomeActivity.class);

                startActivity(intent);

                finish();

            }
        },2500);

        }
}
