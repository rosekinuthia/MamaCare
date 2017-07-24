package com.arjunkapoor.firstdrop;

import android.app.ActionBar;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;




import org.joda.time.LocalDate;
import org.joda.time.Period;
import org.joda.time.PeriodType;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardArrayAdapter;
import it.gmariotti.cardslib.library.internal.CardHeader;
import it.gmariotti.cardslib.library.internal.CardThumbnail;
import it.gmariotti.cardslib.library.view.CardListView;

public class MainActivity extends AppCompatActivity {
    databaseHelper db;
    babyDatabaseManager content;
    Card card;
    int i;
    int total;
    CardArrayAdapter mCardArrayAdapter;
    CardListView listView;
    LinearLayout LayoutOnNullCount;
    int Width;
    int Height;
    int TotalCards;
    static boolean active = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setTitle("FirstDrop");
        db = new databaseHelper(this, null, null, 1);
        total = db.totalCount();



        ArrayList<Card> cards = new ArrayList<Card>();
        Calendar cal = Calendar.getInstance();
        int currentyear = cal.get(Calendar.YEAR);
        int currentMonthtemp = cal.get(Calendar.MONTH);
        int currentmonth = currentMonthtemp + 1;
        int currentday = cal.get(Calendar.DAY_OF_MONTH);
        int displayyear;
        int displaymonth;
        int displayday;

        for (i = 1; i <= total; i++) {
            content = db.getBaby(i);
            if (content.getName().equals("deleted")) {
                continue;
            } else {

                String id = Integer.toString(i);
                card = new Card(this);
                card.setId(id);
                final CardHeader header = new CardHeader(this);

                content = db.getBaby(i);
                header.setTitle(" " + content.getName());

                card.setLongClickable(true);
                card.setClickable(true);
                // for age calculation
                String x = content.getdateofbirth();
                String year = x.substring(0, 4);
                int useryear = Integer.parseInt(year);
                String month = x.substring(5, 7);
                int usermonth = Integer.parseInt(month);
                String day = x.substring(x.lastIndexOf('/') + 1);
                int userday = Integer.parseInt(day);
                LocalDate birthdate = new LocalDate(useryear, usermonth, userday);
                LocalDate now = new LocalDate();
                Period period = new Period(birthdate, now, PeriodType.yearMonthDay());
                displayyear = period.getYears();
                displaymonth = period.getMonths();
                displayday = period.getDays();
                if (displayyear == 0 && displaymonth == 0 && displayday == 0) {
                    card.setTitle(" Welcome to this world " + content.getName());
                } else if (displayyear == 0 && displaymonth == 0 && displayday != 0) {
                    if (displayday == 1)
                        card.setTitle(" " + displayday + " Day old.");
                    else {
                        card.setTitle(" " + displayday + " Days old.");
                    }
                } else if (displayyear == 0 && displaymonth != 0 && displayday >= 0) {
                    if (displaymonth == 1) {
                        card.setTitle(" " + displaymonth + " Month old.");
                    } else {
                        card.setTitle(" " + displaymonth + " Months old.");
                    }
                } else if (displayyear == 1 && displaymonth == 0 && displayday == 0) {
                    if (displayday == 0) {
                        card.setTitle(" HAPPY BRTHADAY " + content.getName());
                    } else {
                        card.setTitle(" " + displayyear + " Year old.");

                    }
                } else if (displayyear != 0 && displaymonth != 0 && displayday >= 0)
                    if (displayyear == 1 && displaymonth > 1) {
                        card.setTitle(" " + displayyear + " Year " + displaymonth + " Months old.");
                    }
                if (displaymonth == 1 && displayyear > 1) {
                    card.setTitle(" " + displayyear + " Years " + displaymonth + " Month old.");
                }
                if (displaymonth == 1 && displayyear == 1) {
                    card.setTitle(" " + displayyear + " Year " + displaymonth + " Month old.");
                }
                if (displaymonth > 1 && displayyear > 1) {
                    card.setTitle(" " + displayyear + " Years " + displaymonth + " Months old.");
                }
                //age calculation end


                card.addCardHeader(header);

                CardThumbnail thumb = new CardThumbnail(this);
                thumb.setDrawableResource(R.drawable.babyface);
                card.addCardThumbnail(thumb);


                cards.add(card);
                card.setOnClickListener(new Card.OnCardClickListener() {
                                            @Override
                                            public void onClick(Card card, View view) {
                                                Intent intent = new Intent(getApplicationContext(), VaccineList.class);
                                                String id = card.getId();
                                                content = db.getBaby(Integer.parseInt(id));
                                                Bundle extras = new Bundle();
                                                extras.putString("name", header.getTitle());
                                                extras.putString("Date",content.getdateofbirth());
                                                intent.putExtras(extras);
                                                startActivity(intent);

                                            }
                                        }
                );
                TotalCards = cards.size();

                card.setOnLongClickListener(new Card.OnLongCardClickListener() {
                    @Override
                    public boolean onLongClick(Card card, View view) {
                        int position = mCardArrayAdapter.getPosition(card) + 1;
                        String cardId = card.getId();
                        final int rowToDelete = Integer.parseInt(cardId);
                        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                        alertDialog.setTitle("FirstDrop");
                        alertDialog.setMessage("Do you want to delete " + content.getName() + " ?");
                        alertDialog.setIcon(android.R.drawable.ic_dialog_alert);
                        alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                db.deleteEntry(rowToDelete);
                                Intent intent = getIntent();
                                overridePendingTransition(0, 5);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                finish();
                                overridePendingTransition(0, 5);
                                startActivity(intent);
                                Toast.makeText(getApplicationContext(), "Deleted", Toast.LENGTH_SHORT).show();
                            }
                        });


                        alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                        alertDialog.show();
                        return true;
                    }
                });


            }
        }

        mCardArrayAdapter = new CardArrayAdapter(this, cards);

        listView = (CardListView) this.findViewById(R.id.myList);
        if (listView != null) {
            listView.setAdapter(mCardArrayAdapter);
        }
        if (TotalCards == 0) {
            LinearLayout layoutexisting = (LinearLayout) findViewById(R.id.cardlinearlayout);
            layoutexisting.setVisibility(LinearLayout.GONE);
            LayoutOnNullCount = new LinearLayout(this);
            LayoutOnNullCount.setBackgroundColor(Color.parseColor("#F2F2F2"));
            LayoutOnNullCount.setOrientation(LinearLayout.VERTICAL);
            LinearLayout.LayoutParams LayoutOnNullCountParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            LayoutOnNullCount.setLayoutParams(LayoutOnNullCountParams);
            TextView Text = new TextView(this);
            Text.setText("\n\n\n\n\n\n\n\n\nBabies you add appear here");
            Text.setGravity(Gravity.CENTER);
            Text.setTextSize(20);

            LayoutOnNullCount.addView(Text);
            LinearLayout layoutparent = (LinearLayout) findViewById(R.id.cardlinearlayoutparent);
            layoutparent.addView(LayoutOnNullCount);


        }
        if(TotalCards>0 && active == false){
            Button profileButton = (Button) findViewById(R.id.profilebutton);
            profileButton.setTextColor(Color.parseColor("#ffffff"));
            profileButton.setBackgroundColor(Color.parseColor("#1f1a1a"));










        }


    }

    public void addBaby(View view) {

        Intent i = new Intent(this, addBaby.class);
        Button btn = (Button) findViewById(R.id.button);
        btn.setBackgroundResource(R.drawable.addbabybutton);

        startActivity(i);


    }
    public void settingsButton(View view) {
        Intent i = new Intent(this, settings.class);



        startActivity(i);





    }
    public void newsButton(View view) {
        Intent i = new Intent(this, news.class);
        startActivity(i);

    }
    public void shareButton(View view) {
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
