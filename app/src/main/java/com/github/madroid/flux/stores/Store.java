package com.github.madroid.flux.stores;

import com.github.madroid.flux.actions.Action;

import org.greenrobot.eventbus.EventBus;


/**
 * created by madroid at 2016-08-22
 */
public abstract class Store{
    private static final String TAG = "Store";

    private  static final EventBus bus = EventBus.getDefault();

    Store() {
    }

    public abstract StoreChangeEvent changeEvent();

    public abstract void onAction(Action action);

    public class StoreChangeEvent {

    }
}
