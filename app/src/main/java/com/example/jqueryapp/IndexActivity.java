package com.example.jqueryapp;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by 会飞的菜猪 on 2017/12/17.
 */

public class IndexActivity extends Activity {
    private SharedPreferences sp;
    private TextView welcome;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index_layout);
        welcome = findViewById(R.id.welcome);
        sp = getSharedPreferences("user",0);
        String account = sp.getString("account","");
        welcome.setText("欢迎你"+account);
    }
}
