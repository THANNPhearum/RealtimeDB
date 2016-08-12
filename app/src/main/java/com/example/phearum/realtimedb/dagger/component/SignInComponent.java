package com.example.phearum.realtimedb.dagger.component;

import com.example.phearum.realtimedb.dagger.scope.SignInScope;
import com.example.phearum.realtimedb.dagger.scope.SignUpScope;
import com.example.phearum.realtimedb.presenters.SignInPresenter;
import com.example.phearum.realtimedb.ui.fragment.SignInFragment;

import dagger.Component;
import nz.bradcampbell.compartment.HasPresenter;

/**
 * Created by phearum on 8/11/16.
 */
@SignInScope
@Component(dependencies = AppComponent.class)
public interface SignInComponent extends HasPresenter<SignInPresenter> {
    void inject(SignInFragment fragment);

}