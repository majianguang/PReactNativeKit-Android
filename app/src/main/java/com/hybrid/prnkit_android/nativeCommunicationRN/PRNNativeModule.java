package com.hybrid.prnkit_android.nativeCommunicationRN;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.modules.core.DeviceEventManagerModule;

/**
 * Created by majianguang on 2017/10/25.
 */

public class PRNNativeModule extends ReactContextBaseJavaModule {

    public ReactApplicationContext mContext;

    private static final String MODULE_NAME = "androidNativeModule";
    private static final String EVENT_NAME = "androidCallJSName";

    public PRNNativeModule(ReactApplicationContext context) {
        super(context);
        mContext = context;
    }
    /**
     * 获取模块名称，RN里面调用就直接用模块名来调用方法
     * 例子：NativeModule.androidNativeModule.xxxx();
     * */
    @Override
    public String getName() {
        return MODULE_NAME;
    }

    /**
    * Android原生调用RN，默认使用RCTDeviceEventEmitter
    * 必须在方法面前添加@ReactMethod表示开放给RN调用的方法
    * */
    public void androidCallRN(String msg) {
        mContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class).emit(EVENT_NAME,msg);
    }


    /**
     * RN调用Android原生，直接调用，不需要返回值
     * 比如需要从RN打开一个新的Native页面等等
     * */
    @ReactMethod
    public void rnNormalCallAndroid(String msg) {
        try{
            Toast toast = Toast.makeText(mContext, msg + "到达Android了", Toast.LENGTH_SHORT);
            toast.show();
            Activity currentActivity = getCurrentActivity();
            if(null != currentActivity)
            {
                Class aimActivity = Class.forName("com.hybrid.prnkit_android.TestActivity");
                Intent intent = new Intent(currentActivity,aimActivity);
                currentActivity.startActivity(intent);
            }
        }catch(Exception e){

            throw new JSApplicationIllegalArgumentException(
                    "无法打开activity页面: "+e.getMessage());
        }
    }

    /**
    * RN调用Android原生，使用Callback方式
    * 注意Callback参数引入的必须是react的，别引入错了
    * */
    @ReactMethod
    public void rnCallAndroidWithCallback(String msg, Callback callback) {
        //处理msg...
        String result = msg + "被Android原生处理啦，我要告诉RN处理结果";

        //回调，可以有多个参数callback.invoke(result,"1","abc");
        callback.invoke(result);
    }
    /**
     * RN调用Android原生，使用Promise方式
     *
     * */
    @ReactMethod
    public void rnCallAndroidWithPromise(String msg, Promise promise) {
        //处理msg...
        String result = msg + "被Android原生处理啦，我要告诉RN处理结果";

        //回调
        promise.resolve(result);

        //error
//        promise.reject(XXXXXXXX);
    }

}
