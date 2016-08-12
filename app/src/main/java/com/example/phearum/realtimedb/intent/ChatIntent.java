package com.example.phearum.realtimedb.intent;

import com.example.phearum.realtimedb.ui.ChatActivity;

import android.content.Context;
import android.content.Intent;

/**
 * Created by phearum on 8/8/16.
 */
public class ChatIntent extends Intent {

    public ChatIntent(Context context) {
        super(context, ChatActivity.class);
    }
}
