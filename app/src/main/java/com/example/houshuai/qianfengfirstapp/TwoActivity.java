package com.example.houshuai.qianfengfirstapp;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by HouShuai on 2016/6/17.
 */

public class TwoActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_two);
        TextView textVIew = (TextView) findViewById(R.id.tv_showTwo);
        textVIew.setText("nihao");
    }
}
