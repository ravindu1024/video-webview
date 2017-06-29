package com.rw.videowebview;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.ActionBar;
import android.util.AttributeSet;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;

/**
 * Created by ravindu on 29/06/17.
 */

public class VideoWebview extends FrameLayout
{
    private WebView webView;
    private FrameLayout frameLayout;
    private VideoChromeClient chromeClient;

    public WebView getWebView()
    {
        return webView;
    }

    public void setFullScreenView(@Nullable ActionBar actionBar, FrameLayout frameLayout)
    {
        this.frameLayout = frameLayout;

        chromeClient.setFullScreenView(actionBar, frameLayout);
    }

    public VideoWebview(@NonNull Context context)
    {
        super(context);
        init(context);
    }

    public VideoWebview(@NonNull Context context, @Nullable AttributeSet attrs)
    {
        super(context, attrs);
        init(context);
    }

    private void init(Context context)
    {
        inflate(context, R.layout.rw_video_webview, this);

        frameLayout = findViewById(R.id.video_view_frame);
        webView = findViewById(R.id.video_view_webview);

        chromeClient = new VideoChromeClient(context, frameLayout, webView);
        webView.setWebChromeClient(chromeClient);
        webView.setWebViewClient(new WebViewClient());

        webView.getSettings().setJavaScriptEnabled(true);
    }
}
