package com.hybrid.prnkit_android.component;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

/**
 * Created by majianguang on 2017/10/25.
 */

public class PRNCircleViewManager extends SimpleViewManager {

    public static final String VIEW_NAME = "MCircle";
    public ReactApplicationContext mContext;

    public PRNCircleViewManager(ReactApplicationContext context) {
        super();
        mContext = context;
    }

    @Override
    public String getName() {
        return VIEW_NAME;
    }

    @Override
    protected CircleView createViewInstance(ThemedReactContext reactContext) {
        return new CircleView(reactContext);
    }

    /**
     * 传输背景色参数
     * @param view
     * @param color
     */
    @ReactProp(name = "color")
    public void setColor(CircleView view, Integer color) {
        view.setColor(color);
    }

    /**
     * 传输半径参数
     * @param view
     * @param radius
     */
    @ReactProp(name = "radius")
    public void setRadius(CircleView view, Integer radius) {
        view.setRadius(radius);
    }
}


