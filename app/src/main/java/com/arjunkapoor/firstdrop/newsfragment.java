package com.arjunkapoor.firstdrop;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import org.w3c.dom.Text;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;


public class newsfragment extends Fragment {
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
    Firebase mRef;




    public newsfragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootview=null;

        rootview=inflater.inflate(R.layout.fragment_newsfragment, container, false);


        return rootview;







    }



       public void onStart(){
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
           if(isNetworkAvailable() == false){
               LinearLayout layoutexisting = (LinearLayout) getView().findViewById(R.id.cardlinearlayoutnewschild);
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
               button.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,     ViewGroup.LayoutParams.WRAP_CONTENT));
               LinearLayout.LayoutParams ll = (LinearLayout.LayoutParams)button.getLayoutParams();
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
               LinearLayout layoutparent = (LinearLayout) getView().findViewById(R.id.cardlinearlayoutnews);
               layoutparent.addView(LayoutOnNullCount);



           }




        mText1 = (TextView) getView().findViewById(R.id.text1);
        mText11  =(TextView) getView().findViewById(R.id.text11);
        mText2  =(TextView) getView().findViewById(R.id.text2);
        mText22  =(TextView) getView().findViewById(R.id.text22);
        mText3  =(TextView) getView().findViewById(R.id.text3);
        mText33  =(TextView) getView().findViewById(R.id.text33);
        mText4  =(TextView) getView().findViewById(R.id.text4);
        mText44  =(TextView) getView().findViewById(R.id.text44);
        mText5  =(TextView) getView().findViewById(R.id.text5);
        mText55  =(TextView) getView().findViewById(R.id.text55);
        mText6  =(TextView) getView().findViewById(R.id.text6);
        mText66  =(TextView) getView().findViewById(R.id.text66);
        mText7  =(TextView) getView().findViewById(R.id.text7);
        mText77  =(TextView) getView().findViewById(R.id.text77);
        mRef=new Firebase("https://project-3625375734556922518.firebaseio.com/News/1");
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text=dataSnapshot.getValue(String.class);
                mText1.setText(text);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        mRef=new Firebase("https://project-3625375734556922518.firebaseio.com/News/1detail");
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text=dataSnapshot.getValue(String.class);
                mText11.setText(text);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        mRef=new Firebase("https://project-3625375734556922518.firebaseio.com/News/2");
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text=dataSnapshot.getValue(String.class);
                mText2.setText(text);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        mRef=new Firebase("https://project-3625375734556922518.firebaseio.com/News/2detail");
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text=dataSnapshot.getValue(String.class);
                mText22.setText(text);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        mRef=new Firebase("https://project-3625375734556922518.firebaseio.com/News/3");
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text=dataSnapshot.getValue(String.class);
                mText3.setText(text);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        mRef=new Firebase("https://project-3625375734556922518.firebaseio.com/News/3detail");
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text=dataSnapshot.getValue(String.class);
                mText33.setText(text);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        mRef=new Firebase("https://project-3625375734556922518.firebaseio.com/News/4");
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text=dataSnapshot.getValue(String.class);
                mText4.setText(text);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        mRef=new Firebase("https://project-3625375734556922518.firebaseio.com/News/4detail");
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text=dataSnapshot.getValue(String.class);
                mText44.setText(text);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        mRef=new Firebase("https://project-3625375734556922518.firebaseio.com/News/5");
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text=dataSnapshot.getValue(String.class);
                mText5.setText(text);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        mRef=new Firebase("https://project-3625375734556922518.firebaseio.com/News/5detail");
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text=dataSnapshot.getValue(String.class);
                mText55.setText(text);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        mRef=new Firebase("https://project-3625375734556922518.firebaseio.com/News/6");
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text=dataSnapshot.getValue(String.class);
                mText6.setText(text);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        mRef=new Firebase("https://project-3625375734556922518.firebaseio.com/News/6detail");
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text=dataSnapshot.getValue(String.class);
                mText66.setText(text);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        mRef=new Firebase("https://project-3625375734556922518.firebaseio.com/News/7");
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text=dataSnapshot.getValue(String.class);
                mText7.setText(text);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        mRef=new Firebase("https://project-3625375734556922518.firebaseio.com/News/7detail");
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text=dataSnapshot.getValue(String.class);
                mText77.setText(text);
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
