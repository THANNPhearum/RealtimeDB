package com.example.phearum.realtimedb.intent;

import com.example.phearum.realtimedb.ui.HomeActivity;

import android.content.Context;
import android.content.Intent;

/**
 * Created by phearum on 8/8/16.
 */
public class HomeIntent extends Intent {

    private static final String ACTION_LOGIN = "action_login";
    private static final String ACTION_LOGOUT = "action_logout";

    private static final String ARG_USERNAME = "arg_username";
    private static final String ARG_PASSWORD = "arg_password";


    public HomeIntent(Context ctx, boolean isLogIn) {
        this(ctx);
        //set action type
        setAction(isLogIn ? ACTION_LOGIN : ACTION_LOGOUT);
    }

    public HomeIntent(Context ctx) {
        super(ctx, HomeActivity.class);
    }

    //This will be needed for receiving data
    public HomeIntent(Intent intent) {
        super(intent);
    }

    public void setUserName(String userName, String password) {
        putExtra(ARG_USERNAME, userName);
        putExtra(ARG_PASSWORD, password);
    }

    public String getUsername() {
        return getStringExtra(ARG_USERNAME);
    }

    public String getPassword() {
        return getStringExtra(ARG_PASSWORD);
    }

    //To separate the params is for which action, we should create action
    public boolean isActionLogIn() {
        return getAction().equals(ACTION_LOGIN);
    }

    public boolean isActionLogOut() {
        return getAction().equals(ACTION_LOGOUT);
    }
}
