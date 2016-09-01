package com.github.madroid.flux.actions;


/**
 * created by madroid at 2016-08-22
 */
public class SetTextAction extends Action<String> {
    private static final String TAG = "SetTextAction";

    public SetTextAction(int type, String data) {
        super(type, data);
    }
}
