package com.github.madroid.flux.stores;

import android.util.Log;

import com.github.madroid.flux.actions.Action;

import org.greenrobot.eventbus.EventBus;

/**
 * created by madroid at 2016-08-22
 */
public class TextStore extends Store {
    private static final String TAG = "TextStore";

    @Override
    public StoreChangeEvent changeEvent() {
        return null;
    }

    @Override
    public void onAction(Action action) {
        Log.i(TAG, "onAction: " + action);
        EventBus.getDefault().post(action);
    }
}
