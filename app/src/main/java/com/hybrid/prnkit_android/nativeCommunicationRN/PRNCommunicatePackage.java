package com.hybrid.prnkit_android.nativeCommunicationRN;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;

import java.util.ArrayList;
import java.util.List;

import com.hybrid.prnkit_android.component.PRNCircleViewManager;

/**
 * Created by majianguang on 2017/10/25.
 */

public class PRNCommunicatePackage implements ReactPackage {

    public PRNNativeModule nativeModule;
    public PRNCircleViewManager webViewMananger;

    @Override
    public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
        List<NativeModule> list = new ArrayList<>();
        nativeModule = new PRNNativeModule(reactContext);
        list.add(nativeModule);
        return list;
    }

    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
        List<ViewManager> list = new ArrayList<>();
        webViewMananger = new PRNCircleViewManager(reactContext);
        list.add(webViewMananger);
        return list;
    }

}
