package com.github.madroid.flux;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.github.madroid.flux.actions.Action;
import com.github.madroid.flux.actions.ActionCreator;
import com.github.madroid.flux.dispatcher.Dispatcher;
import com.github.madroid.flux.stores.TextStore;

import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mEditText ;
    private Button mButton;
    private TextView mText ;

    private Dispatcher mDispatcher ;
    private ActionCreator mActionCreator ;
    private TextStore mStore ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initFlux();
    }

    private void initView() {
        mEditText = (EditText) findViewById(R.id.edit_text) ;
        mButton = (Button) findViewById(R.id.button) ;
        mButton.setOnClickListener(this);
        mText = (TextView) findViewById(R.id.text) ;
    }

    private void initFlux() {
        mDispatcher = Dispatcher.get() ;
        mActionCreator = ActionCreator.get(mDispatcher) ;
        mStore = new TextStore() ;

        mDispatcher.register(mStore, this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mDispatcher.unregister(mStore, this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                if (!TextUtils.isEmpty(mEditText.getText())) {
                    mActionCreator.sendMessage(mEditText.getText().toString());
                }
                break;

            default:
                break;
        }

    }

    @Subscribe
    public void onActionResponse(Action action) {
        mText.setText(action.get().obj.toString());
    }
}
