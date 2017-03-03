package com.symbio.kerrigan;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;

import com.crashlytics.android.Crashlytics;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesUtil;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import io.fabric.sdk.android.Fabric;

class CustomWebViewClient extends WebViewClient
{
    @Override
    public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request)
    {
        String scheme = request.getUrl().getScheme();
        String method = request.getMethod();
        String url = request.getUrl().toString();
        String urlHost = request.getUrl().getHost().toString();

//        if (scheme.equals("app")) {
//            InputStream dataStream = new ByteArrayInputStream("app scheme button data".getBytes(StandardCharsets.UTF_8));
//            return new WebResourceResponse("text/html", "utf-8", dataStream);
//        }

        if (url.equals("app://home")) {
            //should load the app home page
        }

        if (url.equals("app://settings")) {

        }

        if (url.equals("app://crash")) {
            throw new RuntimeException("This is a forced runtime crash");
        }

        return super.shouldInterceptRequest(view, request);
    }
}

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("main", "onCreate");
        super.onCreate(savedInstanceState);

        //initialize crashlytics dependency
        Fabric.with(this, new Crashlytics());

        //set activity layout
        setContentView(R.layout.activity_main);

        //check dependency on google play services
        int status = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(this);
        Log.d("main", "Google Play Service Status: " + status);
        GoogleApiAvailability.getInstance().makeGooglePlayServicesAvailable(this);

        //initialize web-view
        final WebView webView = (WebView)findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new CustomWebViewClient());
        webView.loadUrl("file:///android_asset/web/splash.html");
    }
}
