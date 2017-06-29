package com.rw.videowebview;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.webkit.GeolocationPermissions;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.FrameLayout;

/**
 * Created by ravindu on 29/06/17.
 */

class VideoChromeClient extends WebChromeClient
{
    private View videoProgressView;
    private FrameLayout container;
    private WebView webView;
    private View customView;
    private CustomViewCallback customViewCallback;
    private Context context;
    @Nullable private ActionBar actionBar;
    private Bitmap defaultPoster;


    @SuppressLint("InflateParams")
    public VideoChromeClient(Context context, FrameLayout frameLayout, WebView webView)
    {
        this.container = frameLayout;
        this.webView = webView;
        this.context = context;

        LayoutInflater inflater = LayoutInflater.from(container.getContext());
        videoProgressView = inflater.inflate(R.layout.rw_video_loading, null);
    }

    public void setFullScreenView(@Nullable ActionBar actionBar, FrameLayout frameLayout)
    {
        this.actionBar = actionBar;
        this.container = frameLayout;
    }

    @Override
    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback callback)
    {
        //Log.i(LOGTAG, "here in on ShowCustomView");
        Log.d("IMG", "on show custom view, hide webview");
        webView.setVisibility(View.GONE);

        // if a view already exists then immediately terminate the new one
        if (customView != null) {
            callback.onCustomViewHidden();
            return;
        }

        container.addView(view);
        container.setVisibility(View.VISIBLE);
        customView = view;
        customViewCallback = callback;

        if(actionBar != null)
            actionBar.hide();
    }

    @Override
    public void onHideCustomView() {
        Log.d("IMG", "on hide custom view, show webview");
        if (customView == null)
            return;

        // Hide the custom view.
        customView.setVisibility(View.GONE);

        // Remove the custom view from its container.
        container.removeView(customView);
        customView = null;
        container.setVisibility(View.GONE);
        customViewCallback.onCustomViewHidden();

        webView.setVisibility(View.VISIBLE);
        webView.goBack();
        //Log.i(LOGTAG, "set it to webVew");

        if(actionBar != null)
            actionBar.show();
    }


    @Override
    public View getVideoLoadingProgressView() {
        //Log.i(LOGTAG, "here in on getVideoLoadingPregressView");
        Log.d("IMG", "get video loading view");
        return videoProgressView;
    }

//    @Override
//    public void onReceivedTitle(WebView view, String title) {
//        ((Activity) ).setTitle(title);
//    }

//    @Override
//    public void onProgressChanged(WebView view, int newProgress) {
//        ((Activity) mContext).getWindow().setFeatureInt(Window.FEATURE_PROGRESS, newProgress*100);
//    }

    @Override
    public Bitmap getDefaultVideoPoster()
    {
        defaultPoster = super.getDefaultVideoPoster();
        Log.d("IMG", "getbitmap");
        return defaultPoster;
    }

    @Override
    public void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissions.Callback callback) {
        callback.invoke(origin, true, false);
    }
}
