package com.ailefrom.callback;

import android.content.Context;

public class CallbackApi {
    private static final String TAG = "CallbackApi";
    public Callfun mCallback;
    public Context mContext;

    public CallbackApi(Context context){
        this.mContext = context;
        mCallback = (Callfun) mContext;
    }

    public void onApiSuccess()
    {
        mCallback.onSuccess();
    }

    public void onApiError()
    {
        mCallback.onError();
    }

}
