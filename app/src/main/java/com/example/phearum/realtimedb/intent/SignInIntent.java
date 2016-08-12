package com.example.phearum.realtimedb.intent;

import com.example.phearum.realtimedb.ui.SignInActivity;

import android.content.Context;
import android.content.Intent;

/**
 * Created by phearum on 8/8/16.
 */
public class SignInIntent extends Intent {

    public SignInIntent(Context context) {
        super(context, SignInActivity.class);
    }
}
