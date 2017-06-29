package com.videowebview.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.rw.videowebview.VideoWebview;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VideoWebview videoWebview = (VideoWebview)findViewById(R.id.webview);

        videoWebview.setFullScreenView(getSupportActionBar(), (FrameLayout) findViewById(R.id.fullscreen_view));

        videoWebview.getWebView().loadUrl("http://youtube.com");


    }
}
