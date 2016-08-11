package com.example.phearum.realtimedb.model;

import com.firebase.client.Firebase;

/**
 * Created by phearum on 8/9/16.
 */
public class UserFirebase extends Firebase {
    public static final String USER_URL = "https://bplace-995.firebaseio.com/User";

    public UserFirebase() {
        super(USER_URL);
    }
}
