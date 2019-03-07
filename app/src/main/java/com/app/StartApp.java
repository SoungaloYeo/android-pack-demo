package com.app;

import android.app.Application;

import com.activeandroid.ActiveAndroid;

public class StartApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ActiveAndroid.initialize(this);
    }
}
