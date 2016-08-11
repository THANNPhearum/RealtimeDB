package com.example.phearum.realtimedb.model;

/**
 * Created by phearum on 8/9/16.
 */
public class User {

    public static String NAME = "User";
    private String mName;
    private String mEmail;
    private String mPassword;


    public User() {
        // empty default constructor, necessary for Firebase to be able to deserialize
    }

    public User(String name, String email, String password) {
        mName = name;
        mEmail = email;
        mPassword = password;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        this.mEmail = email;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        this.mPassword = password;
    }

    @Override
    public String toString() {
        return "User{" +
            "mName='" + mName + '\'' +
            ", mEmail='" + mEmail + '\'' +
            ", mPassword='" + mPassword + '\'' +
            '}';
    }
}
