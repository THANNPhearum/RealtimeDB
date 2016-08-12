package com.example.phearum.realtimedb.ui.fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import com.example.phearum.realtimedb.R;
import com.example.phearum.realtimedb.databinding.FragmentHomeBinding;
import com.example.phearum.realtimedb.intent.ChatIntent;
import com.example.phearum.realtimedb.intent.SignInIntent;
import com.example.phearum.realtimedb.intent.SignUpIntent;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by phearum on 8/9/16.
 */
public class HomeFragment extends Fragment {

    private FragmentHomeBinding mHomeBinding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mHomeBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_home, container, false);
        return mHomeBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            startActivity(new ChatIntent(getContext()));
        }
        mHomeBinding.signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new SignUpIntent(getContext()));
                getActivity().finish();
            }
        });

        mHomeBinding.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new SignInIntent(getContext()));
                getActivity().finish();
            }
        });
    }

}
