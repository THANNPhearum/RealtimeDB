package com.example.phearum.realtimedb;

import com.example.phearum.realtimedb.dagger.component.AppComponent;
import com.example.phearum.realtimedb.dagger.component.DaggerAppComponent;
import com.example.phearum.realtimedb.dagger.module.ApplicationModule;
import com.firebase.client.Firebase;

import android.app.Application;
import android.content.Context;

/**
 * Created by phearum on 8/9/16.
 */
public class MyApp extends Application {

    private AppComponent mComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mComponent = DaggerAppComponent.builder()
            .applicationModule(new ApplicationModule(this))
            .build();

        Firebase.setAndroidContext(this);
        Firebase.getDefaultConfig().setPersistenceEnabled(true);
    }

    public static AppComponent getAppComponent(Context context) {
        MyApp app = (MyApp) context.getApplicationContext();
        if (app.mComponent == null) {
            app.mComponent = DaggerAppComponent.builder()
                .applicationModule(new ApplicationModule(app))
                .build();
        }
        return app.mComponent;
    }

    public AppComponent getAppComponent() {
        return mComponent;
    }
}
