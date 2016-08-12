package com.example.phearum.realtimedb.model.entries;

/**
 * Created by phearum on 8/12/16.
 */
public class Message {
    private String message;
    private long time;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
