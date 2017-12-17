package com.example.jqueryapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {
    private WebView webView;
    private String account = "";
    private String password = "";
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        init();
    }
    /*
    通过定义一个与js对象映射的android类与js进行数据交互。
     */
    private  void init(){
        webView = findViewById(R.id.loginWebView);
        webView.getSettings().setJavaScriptEnabled(true);     //设置webView对js的支持。
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);     //对js弹出框的支持。
        webView.loadUrl("file:///android_asset/login.html");     //项目中的 assets 文件夹部署到手机后，就变成了 android_asset。
        webView.addJavascriptInterface(new Object(){                //定义一个对象与js对象映射。
            @JavascriptInterface                                     //为防止安全漏洞，15之后的版本要加注解
            public void send(String userInfo){
                StringTokenizer userInfoStringTokenizer = new StringTokenizer(userInfo,"|");  //StringTokenizer：字符串分解器类。
                account = userInfoStringTokenizer.nextToken();
                password = userInfoStringTokenizer.nextToken();
                sp = getSharedPreferences("user",0);
                SharedPreferences.Editor editor = sp.edit();
                if("".equals(account)){
                    Log.i(account, "send: error");
                }else{
                    editor.putString("account",account);
                    editor.commit();
                }
                Intent intent = new Intent(MainActivity.this,IndexActivity.class);
                startActivity(intent);      //转向下一页面：首页
            }
        },"testform");                                                //"testform表示java对象的别名"



    }






}
