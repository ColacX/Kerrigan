package com.piratpartiet.kerrigan;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.firebase.crash.FirebaseCrash;

//intercepts webview messages for special handling
public class CustomWebViewClient extends WebViewClient
{
    private static final String TAG = "CustomWebViewClient";

    @Override
    public WebResourceResponse shouldInterceptRequest (WebView view, String url)
    {
        try {
            if (url.equals("app://home")) {
                //should load the app home page
            }

            if (url.equals("app://settings")) {

            }

            if (url.equals("app://crash")) {
                throw new RuntimeException("This is a forced runtime crash");
            }

            return super.shouldInterceptRequest(view, url);
        }
        catch (Throwable t){
            FirebaseCrash.report(t);
            throw t;
        }
    }
}
