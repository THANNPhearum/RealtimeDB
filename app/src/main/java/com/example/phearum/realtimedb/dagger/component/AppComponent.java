package com.example.phearum.realtimedb.dagger.component;

import com.example.phearum.realtimedb.dagger.module.ApplicationModule;
import com.example.phearum.realtimedb.dagger.scope.AppScope;
import com.example.phearum.realtimedb.model.SettingFirebase;
import com.example.phearum.realtimedb.model.UserFirebase;
import com.example.phearum.realtimedb.ui.fragment.HomeFragment;
import com.firebase.client.Firebase;

import dagger.Component;

/**
 * Created by phearum on 8/9/16.
 */
@AppScope
@Component(modules = {ApplicationModule.class})
public interface AppComponent {

    Firebase firebase();

    SettingFirebase settingFirebase();

    UserFirebase userFirebase();

    void inject(HomeFragment homeFragment);
}
