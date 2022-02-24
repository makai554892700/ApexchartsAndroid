package com.mys.apexcharts.view;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class ApexchartsView extends WebView {

    public ApexchartsView(Context context) {
        this(context, null);
    }

    public ApexchartsView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ApexchartsView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        WebSettings webSettings = getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setSupportZoom(false);
        webSettings.setDisplayZoomControls(false);
        loadUrl("file:///android_asset/apexcharts.html");
    }

    public void refreshUI(String data) {
        if (data == null) {
            return;
        }
        String call = "javascript:refreshUI('" + data + "')";
        loadUrl(call);
    }
}