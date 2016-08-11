package com.example.phearum.realtimedb.ui;

import com.example.phearum.realtimedb.R;
import com.example.phearum.realtimedb.intent.HomeIntent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by phearum on 8/8/16.
 */
public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        String username = "phearum";
        String password = "pwd1133";
        final boolean isActionLogin = true;
        //Passing data to HomeActivity
        startActivity(new HomeIntent(this, isActionLogin));

    }
}
