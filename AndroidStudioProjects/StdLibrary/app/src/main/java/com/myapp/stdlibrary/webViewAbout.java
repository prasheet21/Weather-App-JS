package com.myapp.stdlibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class webViewAbout extends AppCompatActivity {

    WebView webview ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        webview = findViewById(R.id.webView) ;
        webview.loadUrl("https://www.google.com/");
        webview.setWebViewClient(new WebViewClient());
    }


}
