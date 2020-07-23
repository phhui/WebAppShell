package com.ky.test;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;

public class MainActivity extends Activity {
    private FrameLayout view;
    private PqWebview wv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view=(FrameLayout)this.getWindow().getDecorView();
        createWebview();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
    private void createWebview() {
        wv = new PqWebview(this);
        wv.registerFunc(this,"pq");
        wv.init(new IPqWebviewListener() {
            @Override
            public void onPageFinished(String url) {
                Log.d("log>>>","game is loaded");
//                wv.callJs("initApp('ok')");
            }

            @Override
            public void onReceiveJsValue(String value) {

            }
        });
        wv.loadUrl("file:///android_asset/web/index.html");
        view.addView(wv);
    }
    @JavascriptInterface
    public void signIn(String msg){
        Log.d("log>>>","game  call signIn:"+msg);
    }
}
