# VideoWebview
An Android WebView with full screen video ability

# Installation
- download the project
- import the module 'video-enabled-webview' into your project
- add a dependency on your 'app' module

# Usage
- Basic: 
```xml
    <com.rw.videowebview.VideoWebview
        android:id="@+id/webview"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>
```
```java
    VideoWebview videoWebview = (VideoWebview)findViewById(R.id.webview);
    videoWebview.getWebView().loadUrl("http://vimeo.com");
```
    
- Setting a custom full screen view
   ```java
    videoWebview.setFullScreenView(getSupportActionBar(), (FrameLayout) findViewById(R.id.fullscreen_view));
    ```
