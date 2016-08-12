package com.example.phearum.realtimedb.dagger.component;

import com.example.phearum.realtimedb.dagger.module.ApplicationModule;
import com.example.phearum.realtimedb.dagger.module.UserModule;
import com.example.phearum.realtimedb.dagger.scope.AppScope;
import com.example.phearum.realtimedb.model.UserModel;
import com.example.phearum.realtimedb.ui.fragment.ChatFragment;

import dagger.Component;

/**
 * Created by phearum on 8/9/16.
 */
@AppScope
@Component(modules = {ApplicationModule.class, UserModule.class})
public interface AppComponent {


    UserModel userModel();

    void inject(ChatFragment chatFragment);
}
