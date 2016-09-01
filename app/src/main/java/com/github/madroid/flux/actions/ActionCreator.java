package com.github.madroid.flux.actions;

import android.util.Log;

import com.github.madroid.flux.dispatcher.Dispatcher;

/**
 * created by madroid at 2016-08-22
 */
public class ActionCreator {
    private static final String TAG = "ActionCreator";

    public static final int TYPE_SET_TEXT = 0;

    private static ActionCreator mInstance ;
    private Dispatcher mDispatcher ;

    private ActionCreator(Dispatcher dispatcher) {
        mDispatcher = dispatcher;
    }

    public static ActionCreator get(Dispatcher dispatcher) {
        if (mInstance == null) {
            mInstance = new ActionCreator(dispatcher) ;
        }
        return mInstance ;
    }

    public void sendMessage(String msg) {
        Log.i(TAG, "sendMessage: " + msg);
        mDispatcher.dispatch(new SetTextAction(TYPE_SET_TEXT, msg));
    }

}
