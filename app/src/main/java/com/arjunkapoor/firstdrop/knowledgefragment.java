package com.arjunkapoor.firstdrop;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;


public class knowledgefragment extends Fragment {
    TextView mText1 ;
    TextView mText11;
    TextView mText2  ;
    TextView mText22  ;
    TextView mText3  ;
    TextView mText33  ;
    TextView mText4  ;
    TextView mText44 ;
    TextView mText5  ;
    TextView mText55  ;
    TextView mText6  ;
    TextView mText66  ;
    TextView mText7  ;
    TextView mText77  ;
    TextView mText8  ;
    TextView mText88  ;
    Firebase mRef;




    public knowledgefragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_knowledgefragment, container, false);
    }
    public void onStart() {
        super.onStart();
        /*text = (TextView) getView().findViewById(R.id.textnews);
        mRef = new Firebase("https://project-3625375734556922518.firebaseio.com/news");
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String c = dataSnapshot.getValue(String.class);
                text.setText(c);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
*/
        LinearLayout LayoutOnNullCount;
        if (isNetworkAvailable() == false) {
            LinearLayout layoutexisting = (LinearLayout) getView().findViewById(R.id.cardlinearlayoutknowledgechild);
            layoutexisting.setVisibility(LinearLayout.GONE);
            LayoutOnNullCount = new LinearLayout(getContext());
            LayoutOnNullCount.setBackgroundColor(Color.parseColor("#F2F2F2"));
            LayoutOnNullCount.setOrientation(LinearLayout.VERTICAL);
            LinearLayout.LayoutParams LayoutOnNullCountParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            LayoutOnNullCount.setLayoutParams(LayoutOnNullCountParams);
            TextView Text = new TextView(getContext());
            Text.setText("\n\n\n\n\n\n\nOops!!!\n No connection Detected.");
            Text.setGravity(Gravity.CENTER);
            Text.setTextSize(20);
            Button button = new Button(getContext());
            button.setGravity(Gravity.CENTER);
            button.setText("Try again");
            button.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            LinearLayout.LayoutParams ll = (LinearLayout.LayoutParams) button.getLayoutParams();
            ll.gravity = Gravity.CENTER;
            button.setLayoutParams(ll);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = getActivity().getIntent();
                    getActivity().overridePendingTransition(0, 0);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    getActivity().finish();
                    getActivity().overridePendingTransition(0, 0);
                    startActivity(intent);
                }
            });
            LayoutOnNullCount.addView(Text);
            LayoutOnNullCount.addView(button);
            LinearLayout layoutparent = (LinearLayout) getView().findViewById(R.id.cardlinearlayoutknowledge);
            layoutparent.addView(LayoutOnNullCount);


        }


        mText1 = (TextView) getView().findViewById(R.id.textk1);
        mText11 = (TextView) getView().findViewById(R.id.textk11);
        mText2 = (TextView) getView().findViewById(R.id.textk2);
        mText22 = (TextView) getView().findViewById(R.id.textk22);
        mText3 = (TextView) getView().findViewById(R.id.textk3);
        mText33 = (TextView) getView().findViewById(R.id.textk33);
        mText4 = (TextView) getView().findViewById(R.id.textk4);
        mText44 = (TextView) getView().findViewById(R.id.textk44);
        mText5 = (TextView) getView().findViewById(R.id.textk5);
        mText55 = (TextView) getView().findViewById(R.id.textk55);
        mText6 = (TextView) getView().findViewById(R.id.textk6);
        mText66 = (TextView) getView().findViewById(R.id.textk66);
        mText7 = (TextView) getView().findViewById(R.id.textk7);
        mText77 = (TextView) getView().findViewById(R.id.textk77);
        mText8 = (TextView) getView().findViewById(R.id.textk8);
        mText88 = (TextView) getView().findViewById(R.id.textk88);
        mRef = new Firebase("https://project-3625375734556922518.firebaseio.com/Knowledge/BCG");
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue(String.class);
                mText1.setText(text);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        mRef = new Firebase("https://project-3625375734556922518.firebaseio.com/Knowledge/BCGdetail");
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue(String.class);
                mText11.setText(text);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        mRef = new Firebase("https://project-3625375734556922518.firebaseio.com/Knowledge/HepatitisB");
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue(String.class);
                mText2.setText(text);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        mRef = new Firebase("https://project-3625375734556922518.firebaseio.com/Knowledge/HepatitisBdetail");
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue(String.class);
                mText22.setText(text);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        mRef = new Firebase("https://project-3625375734556922518.firebaseio.com/Knowledge/Polio");
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue(String.class);
                mText3.setText(text);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        mRef = new Firebase("https://project-3625375734556922518.firebaseio.com/Knowledge/Poliodetail");
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue(String.class);
                mText33.setText(text);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        mRef = new Firebase("https://project-3625375734556922518.firebaseio.com/Knowledge/DPT");
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue(String.class);
                mText4.setText(text);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        mRef = new Firebase("https://project-3625375734556922518.firebaseio.com/Knowledge/DPTdetail");
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue(String.class);
                mText44.setText(text);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        mRef = new Firebase("https://project-3625375734556922518.firebaseio.com/Knowledge/HIB");
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue(String.class);
                mText5.setText(text);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        mRef = new Firebase("https://project-3625375734556922518.firebaseio.com/Knowledge/HIBdetail");
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue(String.class);
                mText55.setText(text);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        mRef = new Firebase("https://project-3625375734556922518.firebaseio.com/Knowledge/MMR");
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue(String.class);
                mText6.setText(text);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        mRef = new Firebase("https://project-3625375734556922518.firebaseio.com/Knowledge/MMRdetail");
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue(String.class);
                mText66.setText(text);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        mRef = new Firebase("https://project-3625375734556922518.firebaseio.com/Knowledge/Typhoid");
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue(String.class);
                mText7.setText(text);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        mRef = new Firebase("https://project-3625375734556922518.firebaseio.com/Knowledge/Typhoiddetail");
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue(String.class);
                mText77.setText(text);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        mRef = new Firebase("https://project-3625375734556922518.firebaseio.com/Knowledge/TD");
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue(String.class);
                mText8.setText(text);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        mRef = new Firebase("https://project-3625375734556922518.firebaseio.com/Knowledge/TDdetail");
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue(String.class);
                mText88.setText(text);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }


    }
























