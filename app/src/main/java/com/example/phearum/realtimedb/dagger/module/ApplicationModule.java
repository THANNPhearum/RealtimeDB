package com.example.phearum.realtimedb.dagger.module;

import com.example.phearum.realtimedb.Constant;
import com.example.phearum.realtimedb.MyApp;
import com.example.phearum.realtimedb.dagger.scope.AppScope;
import com.example.phearum.realtimedb.model.SettingFirebase;
import com.example.phearum.realtimedb.model.UserFirebase;
import com.firebase.client.Firebase;

import dagger.Module;
import dagger.Provides;

/**
 * Created by phearum on 8/9/16.
 */
@Module
public class ApplicationModule {

    private final MyApp mApp;


    public ApplicationModule(MyApp app) {
        this.mApp = app;
    }

    @Provides
    @AppScope
    public MyApp provideMyApp() {
        return mApp;
    }

    @Provides
    @AppScope
    public Firebase provideFirebase() {
        return new Firebase(Constant.FIREBASE_URL);
    }

    @Provides
    @AppScope
    public UserFirebase provideUserFirebase() {
        return new UserFirebase();
    }

    @Provides
    @AppScope
    public SettingFirebase provideSettingFirebase() {
        return new SettingFirebase();
    }
}
