package com.okloong.timedown;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

/**
 * Created by loongago on 2018-4-25 0025.
 */

public class App extends Application {

    private final Handler mHandler;

    private static App gApp = null;

    public static App get(){
        return gApp;
    }

    public void onCreate() {
        super.onCreate();
        gApp = this;
    }

    public App(){
        mHandler = new Handler(Looper.getMainLooper());
    }

    public Handler getHandler(){
        return mHandler;
    }
}
