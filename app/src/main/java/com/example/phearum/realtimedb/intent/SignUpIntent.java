package com.example.phearum.realtimedb.intent;

import com.example.phearum.realtimedb.ui.SignUpActivity;

import android.content.Context;
import android.content.Intent;

/**
 * Created by phearum on 8/12/16.
 */
public class SignUpIntent extends Intent {

    public SignUpIntent(Context context) {
        super(context, SignUpActivity.class);
    }
}
