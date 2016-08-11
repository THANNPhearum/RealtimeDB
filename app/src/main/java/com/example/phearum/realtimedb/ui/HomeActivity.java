package com.example.phearum.realtimedb.ui;

import com.example.phearum.realtimedb.R;
import com.example.phearum.realtimedb.ui.fragment.HomeFragment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getSupportFragmentManager()
            .beginTransaction().
            replace(R.id.container, new HomeFragment()).commit();
    }
}
