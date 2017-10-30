package com.hybrid.prnkit_android;

import android.os.Bundle;

import com.facebook.react.*;
import javax.annotation.Nullable;
/**
 * Created by majianguang on 2017/10/24.
 */


public class MyReactActivity extends ReactActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    protected String getMainComponentName() {
        return "HelloWorld";//这个在Registry.registerComponent注册
    }




}