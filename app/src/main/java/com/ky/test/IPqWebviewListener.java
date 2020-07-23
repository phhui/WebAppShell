package com.ky.test;

public interface IPqWebviewListener {
    void onPageFinished(String url);
    void onReceiveJsValue(String value);
}
