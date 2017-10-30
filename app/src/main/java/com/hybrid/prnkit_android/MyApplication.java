package com.hybrid.prnkit_android;

import com.hybrid.prnkit_android.nativeCommunicationRN.PRNCommunicatePackage;
import rn.camera360.pinguo.com.prnkit_android.BuildConfig;

import android.app.Application;

import com.facebook.react.*;
import com.facebook.react.shell.MainReactPackage;

import java.util.Arrays;
import java.util.List;

/**
 * Created by majianguang on 2017/10/24.
 */

public class MyApplication extends Application implements ReactApplication {

    private static MyApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    private final ReactNativeHost mReactNativeHost = new ReactNativeHost(this) {


        @Override
        protected String getJSMainModuleName() {
            return super.getJSMainModuleName();
        }

        @Override
        public boolean getUseDeveloperSupport() {
            //因为有2个BuildConfig.DEBUG的路径，有个默认false，有个默认true
            //这是一个大坑，BuildConfig.DEBUG 默认值竟然是false，我擦，怪不得死活弹不出debug菜单，需要自己去修改
          if (BuildConfig.DEBUG)
          {
              return BuildConfig.DEBUG;
          }
          return true;
        }



        @Override
        protected List<ReactPackage> getPackages() {
            return Arrays.<ReactPackage>asList(
                    new MainReactPackage(),
                    new PRNCommunicatePackage()
            );
        }
    };

    @Override
    public ReactNativeHost getReactNativeHost() {
        return mReactNativeHost;
    }



    public static MyApplication getInstance(){
        return instance;
    }

}
