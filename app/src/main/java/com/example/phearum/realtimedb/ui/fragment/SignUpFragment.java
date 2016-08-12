package com.example.phearum.realtimedb.ui.fragment;

import com.example.phearum.realtimedb.MyApp;
import com.example.phearum.realtimedb.R;
import com.example.phearum.realtimedb.dagger.component.DaggerSignUpComponent;
import com.example.phearum.realtimedb.dagger.component.SignUpComponent;
import com.example.phearum.realtimedb.databinding.FragmentSignupBinding;
import com.example.phearum.realtimedb.intent.ChatIntent;
import com.example.phearum.realtimedb.presenters.SignUpPresenter;

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
public class SignUpFragment extends PresenterControllerFragment<SignUpComponent, SignUpPresenter>
    implements SignUpPresenter.SignUpView {
    private String TAG = SignUpFragment.class.getSimpleName();
    private FragmentSignupBinding mSignupBinding;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected SignUpComponent onCreateNonConfigurationComponent() {
        return DaggerSignUpComponent.builder().appComponent(MyApp.getAppComponent(getActivity())).build();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mSignupBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_signup, container, false);
        return mSignupBinding.getRoot();
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mSignupBinding.signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doSignUp();
            }
        });

    }

    public void doSignUp() {
        String name = mSignupBinding.name.getText().toString();
        String email = mSignupBinding.email.getText().toString();
        String password = mSignupBinding.password.getText().toString();
        getPresenter().signUp(email, password);
    }

    @Override
    public void onSignUpSuccess() {
        startActivity(new ChatIntent(getContext()));
        getActivity().finish();
    }

    @Override
    public void onSignUpFailure(Exception e) {
        Snackbar.make(getView(), R.string.error_signup, Snackbar.LENGTH_SHORT).show();
    }
}
