package com.github.madroid.flux.dispatcher;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;

import com.github.madroid.flux.actions.Action;
import com.github.madroid.flux.actions.ActionCreator;
import com.github.madroid.flux.stores.Store;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

/**
 * created by madroid at 2016-08-22
 */
public class Dispatcher {
    private static final String TAG = "Dispatcher";

    private static Dispatcher mInstance ;
    private Handler mHandler ;
    private List<Store> mList ;

    private Dispatcher() {
        HandlerThread thread = new HandlerThread("Dispatcher") ;
        thread.start();
        mHandler = new Handler(thread.getLooper()) ;
        mList = new ArrayList<>() ;

    }

    public static Dispatcher get() {
        if (mInstance == null) {
            mInstance = new Dispatcher() ;
        }
        return mInstance ;
    }

    public void register(Store store, Object view) {
        mList.add(store);
        EventBus.getDefault().register(view);
    }

    public void unregister(Store store, Object view) {
        mList.remove(store) ;
        EventBus.getDefault().unregister(view);
    }

    public void dispatch(Action action) {
       for (Store store : mList) {
           store.onAction(action);
       }
    }
}
