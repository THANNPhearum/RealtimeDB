package com.example.phearum.realtimedb.presenters;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;

import com.example.phearum.realtimedb.dagger.scope.SignInScope;
import com.example.phearum.realtimedb.model.UserModel;

import android.support.annotation.NonNull;

import javax.inject.Inject;

import nz.bradcampbell.compartment.BasePresenter;

/**
 * Created by phearum on 8/12/16.
 */
@SignInScope
public class SignInPresenter extends BasePresenter<SignInPresenter.SignInView> {


    private final UserModel mUserModel;

    @Inject
    public SignInPresenter(UserModel userModel) {
        this.mUserModel = userModel;
    }

    public void signIn(String email, String password) {
        mUserModel.signIn(email, password)
            .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
                    getView().onSignInSuccess();
                }
            }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                getView().onSignInFailure(e);
            }
        });
    }

    public interface SignInView {

        void onSignInSuccess();

        void onSignInFailure(Exception e);
    }
}
