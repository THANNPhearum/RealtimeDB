package com.example.phearum.realtimedb.model;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import com.example.phearum.realtimedb.MyApp;
import com.example.phearum.realtimedb.dagger.scope.AppScope;

import javax.inject.Inject;

/**
 * Created by phearum on 8/11/16.
 */
@AppScope
public class UserModel {

    private MyApp mMyApp;
    private FirebaseAuth mFirebaseAuth;

    @Inject
    public UserModel(MyApp myApp, FirebaseAuth firebaseAuth) {
        this.mFirebaseAuth = firebaseAuth;
        this.mMyApp = myApp;
    }

    public Task<AuthResult> createUser(final String email, final String password) {
        return mFirebaseAuth.createUserWithEmailAndPassword(email, password);
    }

    public Task<AuthResult> signIn(String email, String password) {
        return mFirebaseAuth.signInWithEmailAndPassword(email, password);
    }

    public void signOut() {
        mFirebaseAuth.signOut();
    }

}
