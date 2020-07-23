package com.ky.test;
import android.content.Context;
import android.util.Log;

public class JsInterface {
    private Context ct;
    public JsInterface(Context c){
        ct=c;
    }
    public void signIn(String msg){
        Log.d("log>>>","game  call signIn:"+msg);
    }
}
