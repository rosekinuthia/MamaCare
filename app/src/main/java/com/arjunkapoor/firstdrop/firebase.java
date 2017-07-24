package com.arjunkapoor.firstdrop;

import com.firebase.client.Firebase;

/**
 * Created by ARJUN on 6/8/2016.
 */
public class firebase extends android.app.Application {

 @Override
    public void onCreate(){
     super.onCreate();
     Firebase.setAndroidContext(this);
 }

}
