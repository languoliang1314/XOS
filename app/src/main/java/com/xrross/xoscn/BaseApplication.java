package com.xrross.xoscn;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import com.xrross.common.utils.DensityUtils;

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        DensityUtils.setDensity(this, 1024);//375为UI提供设计图的宽度
        registerActivityLifecycleCallbacks();
    }

    private  void registerActivityLifecycleCallbacks() {
        registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                DensityUtils.setDefault(activity);
            }
            @Override
            public void onActivityStarted(Activity activity) {
            }
            @Override
            public void onActivityResumed(Activity activity) {
            }
            @Override
            public void onActivityPaused(Activity activity) {
            }
            @Override
            public void onActivityStopped(Activity activity) {
            }
            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
            }
            @Override
            public void onActivityDestroyed(Activity activity) {

            }
        });
    }
}
