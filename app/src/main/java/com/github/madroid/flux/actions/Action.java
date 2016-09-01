package com.github.madroid.flux.actions;

import android.os.Message;

/**
 * created by madroid at 2016-08-22
 */
public class Action<T> {
    private static final String TAG = "Action";

    private Message message ;
    private int type ;
    private T data ;

    public Action(int type, T data) {
        this.type = type ;
        this.data = data ;
        message = Message.obtain() ;
        message.what = type ;
        message.obj = data ;
    }

    public void setType(int type) {
        this.type = type;
        message.what = type ;
    }

    public void setData(T data) {
        this.data = data;
        message.obj = data ;
    }

    public Message get() {
        return message ;
    }
}
