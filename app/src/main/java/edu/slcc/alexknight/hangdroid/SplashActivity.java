package edu.slcc.alexknight.hangdroid;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Runnable wait3seconds = new Runnable() {
            @Override
            public void run() {
                nextActivity();
            }
        };

        Handler handler = new Handler();
        handler.postDelayed(wait3seconds, 3000);
    }

    public void nextActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
