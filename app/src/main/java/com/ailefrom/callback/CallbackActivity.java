package com.ailefrom.callback;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CallbackActivity extends AppCompatActivity implements Callfun{
    private static final String TAG = "CallbackActivity";
    private CallbackApi mCallbackApi;
    private final int duration = 2000;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCallbackApi = new CallbackApi(this);
        TextView success = (TextView) findViewById(R.id.resultPass);
        success.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: CallbackApi send success");
                mCallbackApi.onApiSuccess();
            }
        });
        
        TextView error = (TextView) findViewById(R.id.resultError);
        error.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: CallbackApi send error");
                mCallbackApi.onApiError();
            }
        });
    }


    @SuppressLint("WrongConstant")
    @Override
    public void onSuccess() {
        Log.d(TAG, "CallbackApi Receive onSuccess: ");
        Toast.makeText(this, "onSuccess", duration).show();
    }

    @SuppressLint("WrongConstant")
    @Override
    public void onError() {
        Log.d(TAG, "CallbackApi Receive onError: ");
        Toast.makeText(this, "onError", duration).show();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return super.onKeyDown(keyCode, event);
    }
}