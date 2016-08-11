package com.example.phearum.realtimedb.ui.fragment;

import com.example.phearum.realtimedb.MyApp;
import com.example.phearum.realtimedb.R;
import com.example.phearum.realtimedb.databinding.FragmentHomeBinding;
import com.example.phearum.realtimedb.model.SettingFirebase;
import com.example.phearum.realtimedb.model.User;
import com.example.phearum.realtimedb.model.UserFirebase;
import com.firebase.client.DataSnapshot;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

/**
 * Created by phearum on 8/9/16.
 */
public class HomeFragment extends Fragment {

    private FragmentHomeBinding mHomeBinding;
    @Inject
    UserFirebase mUserFirebase;

    @Inject
    SettingFirebase mSettingFirebase;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mHomeBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_home, container, false);
        return mHomeBinding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApp.getAppComponent(getContext()).inject(this);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mHomeBinding.submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doSubmit();
            }
        });
        mUserFirebase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                try {
                    User user = dataSnapshot.getValue(User.class);
                    Log.e("HomeFragment", "[onDataChange] " + user.toString());
                    String separator = "------------------\n";
                    mHomeBinding.log.append(separator);
                    mHomeBinding.log.append(user.toString());
                } catch (Exception exception) {

                }

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                Log.e("HomeFragment", "[onCancelled] " + firebaseError.getMessage());
            }
        });

        mSettingFirebase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.d("HomeFragment", "[onDataChange] " + dataSnapshot.getKey());
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

    }

    private void doSubmit() {
        String name = mHomeBinding.name.getText().toString();
        String email = mHomeBinding.email.getText().toString();
        String password = mHomeBinding.password.getText().toString();

        User user = new User(name, email, password);
        mUserFirebase.child(User.NAME).setValue(user);

    }


}
