package com.example.phearum.realtimedb.ui.fragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import com.example.phearum.realtimedb.MyApp;
import com.example.phearum.realtimedb.R;
import com.example.phearum.realtimedb.databinding.FragmentChatBinding;
import com.example.phearum.realtimedb.intent.HomeIntent;
import com.example.phearum.realtimedb.model.UserModel;
import com.example.phearum.realtimedb.model.entries.Setting;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
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
public class ChatFragment extends Fragment {

    private FragmentChatBinding mChatBinding;
    @Inject
    FirebaseDatabase mFirebaseDatabase;
    @Inject
    UserModel mUserModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApp.getAppComponent(getContext()).inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mChatBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_chat, container, false);
        return mChatBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        DatabaseReference databaseReference = mFirebaseDatabase.getReference(Setting.TAG);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Setting setting = dataSnapshot.getValue(Setting.class);
                if (setting != null) {
                    mChatBinding.message.setText(setting.getMessage());
                    if (!setting.getColor().isEmpty()) {
                        mChatBinding.message.setBackgroundColor(Color.parseColor(setting.getColor()));
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d("ChatFragment", "DatabaseError: " + databaseError.getMessage());
            }
        });
        mChatBinding.signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mUserModel.signOut();
                startActivity(new HomeIntent(getContext()));
                getActivity().finish();
            }
        });
    }

}
