package com.jorny.aircraftdemo;

import android.app.Application;
import android.content.Context;

public class ApplycationContext extends Application {

    public static Context sContext;
    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;
    }
}
