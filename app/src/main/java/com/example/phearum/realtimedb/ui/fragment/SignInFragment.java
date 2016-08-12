package com.example.phearum.realtimedb.ui.fragment;

import com.example.phearum.realtimedb.MyApp;
import com.example.phearum.realtimedb.R;
import com.example.phearum.realtimedb.dagger.component.DaggerSignInComponent;
import com.example.phearum.realtimedb.dagger.component.SignInComponent;
import com.example.phearum.realtimedb.databinding.FragmentSigninBinding;
import com.example.phearum.realtimedb.intent.ChatIntent;
import com.example.phearum.realtimedb.presenters.SignInPresenter;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nz.bradcampbell.compartment.PresenterControllerFragment;

/**
 * Created by phearum on 8/9/16.
 */
public class SignInFragment extends PresenterControllerFragment<SignInComponent, SignInPresenter>
    implements SignInPresenter.SignInView {

    private FragmentSigninBinding mSigninBinding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mSigninBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_signin, container, false);
        return mSigninBinding.getRoot();
    }

    @Override
    protected SignInComponent onCreateNonConfigurationComponent() {
        return DaggerSignInComponent.builder().appComponent(MyApp.getAppComponent(getActivity())).build();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mSigninBinding.signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doSignIn();
            }
        });

    }

    private void doSignIn() {
        String email = mSigninBinding.email.getText().toString();
        String password = mSigninBinding.password.getText().toString();
        getPresenter().signIn(email, password);
    }

    @Override
    public void onSignInSuccess() {
        startActivity(new ChatIntent(getContext()));
        getActivity().finish();
    }

    @Override
    public void onSignInFailure(Exception e) {
        Snackbar.make(getView(), R.string.error_signin, Snackbar.LENGTH_SHORT).show();
    }
}
