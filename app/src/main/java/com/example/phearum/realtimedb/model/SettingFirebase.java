package com.example.phearum.realtimedb.model;

import com.firebase.client.Firebase;

/**
 * Created by phearum on 8/9/16.
 */
public class SettingFirebase extends Firebase {
    public static final String SETTING_URL = "https://bplace-995.firebaseio.com/Setting";

    public SettingFirebase() {
        super(SETTING_URL);
    }
}
