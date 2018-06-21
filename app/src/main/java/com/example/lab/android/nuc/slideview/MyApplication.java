package com.example.lab.android.nuc.slideview;

import android.app.Application;
import android.content.Context;

public class MyApplication extends Application{
    public static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;
    }
}
