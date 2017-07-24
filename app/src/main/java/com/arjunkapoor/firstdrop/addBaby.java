package com.arjunkapoor.firstdrop;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.provider.CalendarContract;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.text.DateFormatSymbols;
import java.util.Calendar;


public class addBaby extends AppCompatActivity {
    EditText babynametext;
    EditText babydob;
    EditText babygendertext;
    int year_x, month_x, day_x;
    static final int DIALOG_ID = 0;
    babyDatabaseManager content;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_baby);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_addBaby);
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setTitle("Please Enter Details");
        final Calendar calendar = Calendar.getInstance();
        year_x = calendar.get(Calendar.YEAR);
        month_x = calendar.get(Calendar.MONTH);
        day_x = calendar.get(Calendar.DAY_OF_MONTH);
        showDialogOnEditClick();
        Button doneButton = (Button) findViewById(R.id.done);
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                babynametext = (EditText) findViewById(R.id.babyname);
                babydob = (EditText) findViewById(R.id.dateofbirth);
                babygendertext = (EditText) findViewById(R.id.gender);
                String babynametextdata = babynametext.getText().toString();
                String babydobdata = babydob.getText().toString();

                String babygendertextdata = babygendertext.getText().toString();
                databaseHelper db = new databaseHelper(getApplication(), null, null, 1);
                if (babynametext.getText().toString().trim().length() == 0) {
                    Toast.makeText(getApplication(), "Please enter baby name", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (babydob.getText().toString().trim().length() == 0) {
                    Toast.makeText(getApplication(), "Please enter Date of Birth", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (babygendertext.getText().toString().trim().length() == 0) {
                    Toast.makeText(getApplication(), "Please enter Gender", Toast.LENGTH_SHORT).show();
                    return;
                }

                db.addBaby(new babyDatabaseManager(babynametextdata,
                        babydobdata, babygendertextdata));



                Intent i = new Intent(addBaby.this, MainActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });
    }

    AlertDialog.Builder alert;

    public void genderButton(View view) {
        final CharSequence[] gender = {"Male", "Female"};
        alert = new AlertDialog.Builder(addBaby.this);
        alert.setTitle("Select Gender");

        alert.setSingleChoiceItems(gender, -1, new DialogInterface.OnClickListener() {
            String gen;

            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (gender[which] == "Male") {
                    gen = "1";
                    babygendertext = (EditText) findViewById(R.id.gender);
                    babygendertext.setText("Male");
                    dialog.dismiss();
                } else if (gender[which] == "Female") {
                    gen = "2";
                    babygendertext = (EditText) findViewById(R.id.gender);
                    babygendertext.setText("Female");
                    dialog.dismiss();
                }
            }
        });
        alert.show();

    }

    public void showDialogOnEditClick() {
        babydob = (EditText) findViewById(R.id.dateofbirth);
        babydob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DIALOG_ID);
            }
        });


    }

    protected Dialog onCreateDialog(int id) {
        if (id == DIALOG_ID) {
            return new DatePickerDialog(this, datepickerListener, year_x, month_x, day_x);
        }
        return null;

    }

    private DatePickerDialog.OnDateSetListener datepickerListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            year_x = year;
            month_x = monthOfYear + 1;
            day_x = dayOfMonth;
            babydob = (EditText) findViewById(R.id.dateofbirth);
            if (month_x < 10) {
                babydob.setText(year_x + "/" + "0" + month_x + "/" + day_x);
            } else {
                babydob.setText(year_x + "/" + month_x + "/" + day_x);
            }

        }
    };

    public String getMonth(int month) {
        return new DateFormatSymbols().getMonths()[month_x - 1];
    }


}
