package com.arjunkapoor.firstdrop;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;



import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

import it.gmariotti.cardslib.library.cards.actions.BaseSupplementalAction;
import it.gmariotti.cardslib.library.cards.actions.TextSupplementalAction;
import it.gmariotti.cardslib.library.cards.material.MaterialLargeImageCard;
import it.gmariotti.cardslib.library.internal.Card;

public class news extends AppCompatActivity {



    LinearLayout LayoutOnNullCount;
    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarnews);
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setTitle("News");

            Button newsButton = (Button) findViewById(R.id.new_buttonnews);
            newsButton.setTextColor(Color.parseColor("#ffffff"));
            newsButton.setBackgroundColor(Color.parseColor("#1f1a1a"));
            viewPager = (ViewPager) findViewById(R.id.viewpager);
            setupViewPager(viewPager);

            tabLayout = (TabLayout) findViewById(R.id.tabs);
            tabLayout.setupWithViewPager(viewPager);
            Intent i = getIntent();
            int tabvalue = i.getIntExtra("tab value", -1);

            if(tabvalue != -1) {
                viewPager.setCurrentItem(tabvalue);

            }


/*if(isNetworkAvailable() == false){
    LinearLayout layoutexisting = (LinearLayout) findViewById(R.id.hello);
    layoutexisting.setVisibility(LinearLayout.GONE);
    LayoutOnNullCount = new LinearLayout(this);
    LayoutOnNullCount.setBackgroundColor(Color.parseColor("#F2F2F2"));
    LayoutOnNullCount.setOrientation(LinearLayout.VERTICAL);
    LinearLayout.LayoutParams LayoutOnNullCountParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
    LayoutOnNullCount.setLayoutParams(LayoutOnNullCountParams);
    TextView Text = new TextView(this);
    Text.setText("\n\n\n\n\n\n\n\n\nNo internet connection");
    Text.setGravity(Gravity.CENTER);
    Text.setTextSize(20);


    LayoutOnNullCount.addView(Text);
    LinearLayout layoutparent = (LinearLayout) findViewById(R.id.hello);
    layoutparent.addView(LayoutOnNullCount);
Toast.makeText(this,"No connection detected",Toast.LENGTH_SHORT).show();



}*/
}


    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new newsfragment(), "NEWS");
        adapter.addFragment(new knowledgefragment(), "KNOWLEDGE");
        viewPager.setAdapter(adapter);
    }
    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }


    public void profilebuttonnews(View view) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
    public void sharebuttonnews(View view) {
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        String shareBody = "Hey here I found this cool application on play store for baby immnuization.Do download it from Google play via  = ";
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(sharingIntent, "Share via"));

    }
    public void settingsbuttonnews(View view) {
        Intent i = new Intent(this, settings.class);
        startActivity(i);
    }

    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}