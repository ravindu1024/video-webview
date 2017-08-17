# VideoWebview
An Android WebView with full screen video ability

![alt text](https://raw.githubusercontent.com/ravindu1024/video-webview/master/screenshots/1.png)
![alt text](https://raw.githubusercontent.com/ravindu1024/video-webview/master/screenshots/2.png)
![alt text](https://raw.githubusercontent.com/ravindu1024/video-webview/master/screenshots/3.png)

# Installation
Add this to your main project gradle file
```gradle
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

Then add this to your app/module gradle dependencies
```gradle
	dependencies {
	        compile 'com.github.ravindu1024:video-webview:1.0.0'
	}

```

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
