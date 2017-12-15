package com.example.jqueryapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        init();
    }

    private  void init(){
        webView = findViewById(R.id.loginWebView);
        webView.getSettings().setJavaScriptEnabled(true);     //设置webView对js的支持。
        webView.loadUrl("file:///android_asset/login.html");     //项目中的 assets 文件夹部署到手机后，就变成了 android_asset。
    }


}
