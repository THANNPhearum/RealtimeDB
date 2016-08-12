package com.example.phearum.realtimedb.ui;

import com.example.phearum.realtimedb.R;
import com.example.phearum.realtimedb.ui.fragment.ChatFragment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by phearum on 8/12/16.
 */
public class ChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        getSupportFragmentManager()
            .beginTransaction().
            replace(R.id.container, new ChatFragment()).commit();
    }
}
