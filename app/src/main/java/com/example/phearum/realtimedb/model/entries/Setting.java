package com.example.phearum.realtimedb.model.entries;

/**
 * Created by phearum on 8/12/16.
 */
public class Setting {
    public static String TAG = "Setting";
    private String color;
    private String message;

    public Setting() {
        // empty default constructor, necessary for Firebase to be able to deserialize
    }

    public Setting(String color, String message) {
        this.color = color;
        this.message = message;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
