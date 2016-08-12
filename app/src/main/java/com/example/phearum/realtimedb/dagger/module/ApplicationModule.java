package com.example.phearum.realtimedb.dagger.module;

import com.google.firebase.database.FirebaseDatabase;

import com.example.phearum.realtimedb.MyApp;
import com.example.phearum.realtimedb.dagger.scope.AppScope;

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
    public FirebaseDatabase provideFirebase() {
        return FirebaseDatabase.getInstance();
    }

}
