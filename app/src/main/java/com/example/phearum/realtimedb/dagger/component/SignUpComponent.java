package com.example.phearum.realtimedb.dagger.component;

import com.example.phearum.realtimedb.dagger.scope.SignUpScope;
import com.example.phearum.realtimedb.presenters.SignUpPresenter;
import com.example.phearum.realtimedb.ui.fragment.SignUpFragment;

import dagger.Component;
import nz.bradcampbell.compartment.HasPresenter;

/**
 * Created by phearum on 8/11/16.
 */
@SignUpScope
@Component(dependencies = AppComponent.class)
public interface SignUpComponent extends HasPresenter<SignUpPresenter> {
    void inject(SignUpFragment fragment);

}