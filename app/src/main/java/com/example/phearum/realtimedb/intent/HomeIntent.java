package com.example.phearum.realtimedb.intent;

import com.example.phearum.realtimedb.ui.HomeActivity;

import android.content.Context;
import android.content.Intent;

/**
 * Created by phearum on 8/8/16.
 */
public class HomeIntent extends Intent {

    public HomeIntent(Context context) {
        super(context, HomeActivity.class);
    }
}
