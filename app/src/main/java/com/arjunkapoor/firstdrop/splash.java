package com.arjunkapoor.firstdrop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


    Thread timerThread = new Thread() {
        public void run() {
            try {
                sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                Intent intent = new Intent(splash.this, MainActivity.class);
                startActivity(intent);
            }
        }
    };
    timerThread.start();
}

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        finish();
    }


}
