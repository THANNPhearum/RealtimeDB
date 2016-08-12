package com.example.phearum.realtimedb.dagger.module;

import com.google.firebase.auth.FirebaseAuth;

import com.example.phearum.realtimedb.dagger.scope.AppScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by phearum on 8/11/16.
 */
@Module
public class UserModule {


    @Provides
    @AppScope
    public FirebaseAuth provideFirebaseAuth() {
        return FirebaseAuth.getInstance();
    }

}
