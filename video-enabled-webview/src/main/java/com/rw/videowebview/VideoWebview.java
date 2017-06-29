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

import java.util.Map;

/**
 * Created by ravindu on 29/06/17.
 *
 * A Webview wrapped in a FrameLayout that supports full screen html5
 * video playback out of the box.
 *
 */
public class VideoWebview extends FrameLayout
{
    private WebView webView;
    private FrameLayout frameLayout;
    private VideoChromeClient chromeClient;


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

    /**
     * get the internal webview
     * @return underlying webview object
     */
    public WebView getWebView()
    {
        return webView;
    }

    /**
     * Sets an external view as the full screen playback view.
     * If the actionBar object is provided, it will be hidden in fullscreen mode
     * @param actionBar actionbar of the calling activity
     * @param frameLayout external fullscreen view
     */
    public void setFullScreenView(@Nullable ActionBar actionBar, FrameLayout frameLayout)
    {
        this.frameLayout = frameLayout;

        chromeClient.setFullScreenView(actionBar, frameLayout);
    }

    /**
     * {@link WebView#loadUrl(String)}
     */
    public void loadUrl(String url)
    {
        webView.loadUrl(url);
    }

    /**
     * {@link WebView#loadUrl(String, Map)}
     */
    public void loadUrl(String url, Map<String, String> additionalHttpHeaders)
    {
        webView.loadUrl(url, additionalHttpHeaders);
    }

    /**
     * {@link WebView#loadData(String, String, String)}
     */
    public void loadData(String data, String mimeType, String encoding)
    {
        webView.loadData(data, mimeType, encoding);
    }

    /**
     * {@link WebView#loadDataWithBaseURL(String, String, String, String, String)}
     */
    public void loadDataWithBaseURL (String baseUrl, String data, String mimeType, String encoding, String historyUrl)
    {
        webView.loadDataWithBaseURL(baseUrl, data, mimeType, encoding, historyUrl);
    }

    /**
     * Warning : do not set 'setJavaScriptEnabled(false)' as it will
     * break video playback
     * @return settings of the underlying webview
     */
    public WebSettings getSettings()
    {
        return webView.getSettings();
    }

    /**
     * {@link WebView#canGoBack()}
     */
    public boolean canGoBack()
    {
        return webView.canGoBack();
    }

    /**
     * {@link WebView#canGoForward()}
     */
    public boolean canGoForward()
    {
        return webView.canGoForward();
    }

    /**
     * {@link WebView#canGoBackOrForward(int)}
     */
    public boolean canGoBackOrForward(int steps)
    {
        return webView.canGoBackOrForward(steps);
    }

    /**
     * {@link WebView#goBack()}
     */
    public void goBack()
    {
        webView.goBack();
    }

    /**
     * {@link WebView#goForward()}
     */
    public void goForward()
    {
        webView.goForward();
    }

    /**
     * {@link WebView#goBackOrForward(int)}
     */
    public void goBackOrForward(int steps)
    {
        webView.goBackOrForward(steps);
    }

    /**
     * {@link WebView#setWebViewClient(WebViewClient)}
     */
    public void setWebViewClient(WebViewClient client)
    {
        webView.setWebViewClient(client);
    }



}
