package com.piratpartiet.kerrigan;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.firebase.crash.FirebaseCrash;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;

//the first activity that starts
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate");
        super.onCreate(savedInstanceState);

        //setup crash reporting
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler(){
            @Override
            public void uncaughtException(Thread thread, Throwable ex) {
                FirebaseCrash.report(ex);
            }
        });

        //set activity layout
        setContentView(R.layout.activity_main);

        //check dependency on google play services
        int status = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(this);
        Log.d(TAG, "Google Play Service Status: " + status);
        GoogleApiAvailability.getInstance().makeGooglePlayServicesAvailable(this);

        //subscribe to FCM global topic
        FirebaseMessaging.getInstance().subscribeToTopic("global");
        Log.d(TAG, "firebaseToken: " + FirebaseInstanceId.getInstance().getToken());

        //initialize web-view
        final WebView webView = (WebView)findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new CustomWebViewClient());
        webView.loadUrl("file:///android_asset/web/splash.html");

        //throw new RuntimeException("This is a forced runtime exception");
    }
}
