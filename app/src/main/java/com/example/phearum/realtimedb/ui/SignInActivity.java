package com.example.phearum.realtimedb.ui;

import com.example.phearum.realtimedb.R;
import com.example.phearum.realtimedb.ui.fragment.SignInFragment;

import android.os.Bundle;

import nz.bradcampbell.compartment.ComponentCacheActivity;

public class SignInActivity extends ComponentCacheActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        getSupportFragmentManager()
            .beginTransaction().
            replace(R.id.container, new SignInFragment()).commit();
    }
}
