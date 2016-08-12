package com.example.phearum.realtimedb.presenters;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;

import com.example.phearum.realtimedb.dagger.scope.SignUpScope;
import com.example.phearum.realtimedb.model.UserModel;

import android.support.annotation.NonNull;

import javax.inject.Inject;

import nz.bradcampbell.compartment.BasePresenter;

/**
 * Created by phearum on 8/12/16.
 */
@SignUpScope
public class SignUpPresenter extends BasePresenter<SignUpPresenter.SignUpView> {


    private final UserModel mUserModel;

    @Inject
    public SignUpPresenter(UserModel userModel) {
        this.mUserModel = userModel;
    }

    public void signUp(String email, String password) {
        mUserModel.createUser(email, password)
            .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
                    getView().onSignUpSuccess();
                }
            }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                getView().onSignUpFailure(e);
            }
        });
    }

    public interface SignUpView {

        void onSignUpSuccess();

        void onSignUpFailure(Exception e);
    }
}
