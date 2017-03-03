package com.symbio.kerrigan;

import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

//intercepts webview messages for special handling
public class CustomWebViewClient extends WebViewClient
{
    private static final String TAG = "CustomWebViewClient";

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
