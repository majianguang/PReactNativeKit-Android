package com.hybrid.prnkit_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import rn.camera360.pinguo.com.prnkit_android.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
    /**
    * 原生跳转到RN页面
    * */
    public void gotoRNPage (View v) {
        startActivity(new Intent(this, MyReactActivity.class));
    }
}
