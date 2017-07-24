package com.arjunkapoor.firstdrop;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class settings extends AppCompatActivity {
    static boolean active = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarsettings);
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setTitle("Settings");
        if(active == false){
            Button settingsButton = (Button) findViewById(R.id.settingsbuttonsettings);
            settingsButton.setTextColor(Color.parseColor("#ffffff"));
            settingsButton.setBackgroundColor(Color.parseColor("#1f1a1a"));
        }

        // listview
        ArrayAdapter adaptersettings;




        final ListView settingslist = (ListView) findViewById(R.id.listsettings);
        final ArrayList<HashMap<String, Object>> items = new ArrayList<HashMap<String,Object>>();
        HashMap<String, Object> listItem1;
        HashMap<String, Object> listItem2;
        HashMap<String, Object> listItem3;
        HashMap<String, Object> listItem4;
        HashMap<String, Object> listItem5;

        listItem1 = new HashMap<String, Object>();
        listItem1.put("title", "Knowledge");
        listItem1.put("sub", "Know more about Vaccinations");
        items.add(listItem1);
        listItem2 = new HashMap<String, Object>();
        listItem2.put("title", "Reminder Timings");
        listItem2.put("sub", "Set Reminder as per your convinence");
        items.add(listItem2);
        listItem3 = new HashMap<String, Object>();
        listItem3.put("title", "Rate Us");
        listItem3.put("sub", "It will take just a minute");
        items.add(listItem3);
        listItem4 = new HashMap<String, Object>();
        listItem4.put("title", "Feedback");
        listItem4.put("sub", "We would love to hear from you");
        items.add(listItem4);
        listItem5 = new HashMap<String, Object>();
        listItem5.put("title", "About");
        listItem5.put("sub", "About FirstDrop");
        items.add(listItem5);

        SimpleAdapter adapter = new SimpleAdapter(this, items, R.layout.settingslistview, new String[]{"title", "sub"}, new int[]{R.id.text1, R.id.text2});
        settingslist.setAdapter(adapter);

        settingslist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {



if(position == 3){
    Intent i = new Intent(Intent.ACTION_SEND);
    i.setType("message/rfc822");
    i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"Arjunkapoor817@gmail.com"});
    i.putExtra(Intent.EXTRA_SUBJECT, "FirstDrop User Feedback");
    i.putExtra(Intent.EXTRA_TEXT   , "");
    try {
        startActivity(Intent.createChooser(i, "Send mail..."));
    } catch (android.content.ActivityNotFoundException ex) {
        Toast.makeText(settings.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
    }
}
                if(position == 4){
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(settings.this,R.style.AppCompatAlertDialogStyle);
                    builder1.setMessage("FirstDrop is one of its kind Application made specially to keep track of childrens vaccination.It has been designed to make sure that you never miss the schedule of your child's vaccination.");
                    builder1.setCancelable(true);
                    builder1.setTitle("FirstDrop");
                    builder1.setIcon(R.drawable.main_logo1);

                    builder1.setPositiveButton(
                            "DONE",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });



                    AlertDialog alert11 = builder1.create();
                    alert11.show();




                }
                if(position == 0){
                    Intent i = new Intent(settings.this,news.class);
                    i.putExtra("tab value",1);
                    startActivity(i);
                }

            }
        });


    }





    public void profileButtonSettings(View view) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
    public void newsButtonSettings(View view) {
        Intent i = new Intent(this, news.class);
        startActivity(i);
    }

    public void shareButtonsettings(View view) {
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        String shareBody = "Hey here I found this cool application on play store for baby immnuization.Do download it from Google play via  = ";
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(sharingIntent, "Share via"));
    }
    public void onStart() {
        super.onStart();
        active = true;
    }
    public void onStop() {
        super.onStop();
        active = false;
    }
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

}
