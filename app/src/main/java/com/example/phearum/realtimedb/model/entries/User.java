package com.example.phearum.realtimedb.model.entries;

/**
 * Created by phearum on 8/9/16.
 */
public class User {

    public static String TAG = "User";
    private String mName;
    private String mUId;


    public User() {
        // empty default constructor, necessary for Firebase to be able to deserialize
    }

    public User(String name) {
        mName = name;

    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

}
