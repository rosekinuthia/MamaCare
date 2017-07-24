package com.arjunkapoor.firstdrop;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.zip.Inflater;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardArrayAdapter;
import it.gmariotti.cardslib.library.internal.CardExpand;
import it.gmariotti.cardslib.library.internal.CardHeader;
import it.gmariotti.cardslib.library.internal.CardThumbnail;
import it.gmariotti.cardslib.library.internal.ViewToClickToExpand;
import it.gmariotti.cardslib.library.view.CardListView;
import it.gmariotti.cardslib.library.view.CardView;
import it.gmariotti.cardslib.library.view.CardViewNative;




public class VaccineList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccine_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_VaccineList);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String valuename = extras.getString("name");
        String valuedate = extras.getString("Date");
        String year = valuedate.substring(0, 4);
        int useryear = Integer.parseInt(year);
        String month = valuedate.substring(5, 7);
        int usermonth = Integer.parseInt(month);
        String day = valuedate.substring(valuedate.lastIndexOf('/') + 1);
        int userday = Integer.parseInt(day);
        ArrayList<Integer> yearvaccine = new ArrayList<Integer>();
        ArrayList<Integer> monthvaccine = new ArrayList<Integer>();
        ArrayList<Integer> dayvaccine = new ArrayList<Integer>();
        ArrayList<String> monthStringvaccine = new ArrayList<String>();
        int[] numbers = {0,0,0,42,42,42,42,70,70,70,70,98,98,98,270,450,540,540,540,730,1825,1825,1825,1825,2920,3650,4015,5110,5840};

        for (int i : numbers) {

            String monthofvaccine = null;
            Calendar date = new GregorianCalendar(useryear, usermonth - 1, userday);
            date.add(Calendar.DAY_OF_MONTH, +i);
            yearvaccine.add(date.get(Calendar.YEAR));
            int x = (date.get(Calendar.MONTH))+1;
            switch(x){
                case 1:monthofvaccine = "Jan";
                    break;
                case 2:monthofvaccine = "Feb";
                    break;
                case 3:monthofvaccine = "March";
                    break;
                case 4:monthofvaccine = "April";
                    break;
                case 5:monthofvaccine = "May";
                    break;
                case 6:monthofvaccine = "June";
                    break;
                case 7:monthofvaccine = "July";
                    break;
                case 8:monthofvaccine = "Aug";
                    break;
                case 9:monthofvaccine = "Sep";
                    break;
                case 10:monthofvaccine = "Oct";
                    break;
                case 11:monthofvaccine = "Nov";
                    break;
                case 12:monthofvaccine = "Dec";
                    break;
            }
            monthvaccine.add(x);
            monthStringvaccine.add(monthofvaccine);
            dayvaccine.add(date.get(Calendar.DAY_OF_MONTH));
        }





                TextView titlename = (TextView) findViewById(R.id.toolbartitle_vaccinelist);
        titlename.setText(valuename);
        String[] vaccineName = {"BCG", "Hepatitis B1", "OPV0", "OPV1 / IPV", "DPT1 / DTaP1", "Hepatitis B2",
                "HIB1", "DPT2 / DTaP2", "OPV2 / IPV", "HIB2+Hepatitis B3", "Hepatitis B4",
                "DPT3 / DTaP3", "HIB3", "OPV3+IPV", "Measels", "MMR", "DPT / DTaP Booster1",
                "HIB Booster", "OPV Booster / IPV1", "Typhoid", "DPT / DTaP Booster", "OPV Booster / IPV2", "MMR",
                "Typhoid 2", "Typhoid 3", "TD", "Typhoid 4", "Typhoid 5", "TD"};
        String[] description = {"It protects your child against Tuberculosis.Should be given as as close of time of birth as possible.",
                "It protects your child against Hepatisis B virus,which lead to Liver damage and even Death.First dose is recommended at the time of Birth.",
                "It is ORAL POLIO VACCINE.It protects your child against Polio,\nTwo types available:\n-INACTIVE POLIO VACCINE(IPV)\n-ORAL POLIO VACCINE(OPV).",
                "It is ORAL POLIO VACCINE.It protects your child against Polio,\n" +
                        "Two types available:\n" +
                        "-INACTIVE POLIO VACCINE(IPV)\n" +
                        "-ORAL POLIO VACCINE(OPV).",
                "It protects your child against diseases like DIPHTHERIA,TETANUS,and PERTUSIS.Vaccine components include Diphtheria and tetanus toxoids and kill whole cells of organism that causes Pertusis.",
                "It protects your child against Hepatisis B virus,which lead to Liver damage and even Death.First dose is recommended at the time of Birth.",
                "It is a single injection to boost baby protection against five different childhood diseases:\n-Diphtheria\n-Tetanus\n-Pertussis\n-Polio and\n-HIB(Haemophilus Influenzae type B).",
                "It protects your child against diseases like DIPHTHERIA,TETANUS,and PERTUSIS.Vaccine components include Diphtheria and tetanus toxoids and kill whole cells of organism that causes Pertusis.",
                "It is ORAL POLIO VACCINE.It protects your child against Polio,\n" +
                        "Two types available:\n" +
                        "-INACTIVE POLIO VACCINE(IPV)\n" +
                        "-ORAL POLIO VACCINE(OPV).",
                "It is a single injection to boost baby protection against five different childhood diseases:\n" +
                        "-Diphtheria\n" +
                        "-Tetanus\n" +
                        "-Pertussis\n" +
                        "-Polio and\n" +
                        "-HIB(Haemophilus Influenzae type B)." +
                        " Hepatisis B protects your child against Hepatisis B virus,which lead to Liver damage and even Death.First dose is recommended at the time of Birth.",
                "It protects your child against Hepatisis B virus,which lead to Liver damage and even Death.First dose is recommended at the time of Birth.",
                "It protects your child against diseases like DIPHTHERIA,TETANUS,and PERTUSIS.Vaccine components include Diphtheria and tetanus toxoids and kill whole cells of organism that causes Pertusis.",
                "It is a single injection to boost baby protection against five different childhood diseases:\n" +
                        "-Diphtheria\n" +
                        "-Tetanus\n" +
                        "-Pertussis\n" +
                        "-Polio and\n" +
                        "-HIB(Haemophilus Influenzae type B).",
                "It is ORAL POLIO VACCINE.It protects your child against Polio,\n" +
                        "Two types available:\n" +
                        "-INACTIVE POLIO VACCINE(IPV)\n" +
                        "-ORAL POLIO VACCINE(OPV).",
                "It is a individual Vaccine and given in combination with Mumps and Rubella. ",
                "It is MEASLES MUMPS RUBELLA(MMR),is a live attenuated viral Vaccine used to induce immunity against Measles,Mumps,and Rubella.",
                "It protects your child against diseases like DIPHTHERIA,TETANUS,and PERTUSIS.Vaccine components include Diphtheria and tetanus toxoids and kill whole cells of organism that causes Pertusis.",
                "It is a single injection to boost baby protection against five different childhood diseases:\n" +
                        "-Diphtheria\n" +
                        "-Tetanus\n" +
                        "-Pertussis\n" +
                        "-Polio and\n" +
                        "-HIB(Haemophilus Influenzae type B).",
                "It is ORAL POLIO VACCINE.It protects your child against Polio,\n" +
                        "Two types available:\n" +
                        "-INACTIVE POLIO VACCINE(IPV)\n" +
                        "-ORAL POLIO VACCINE(OPV).",
                "It is given to baby to prevent Typhoid Fever.",
                "It protects your child against diseases like DIPHTHERIA,TETANUS,and PERTUSIS.Vaccine components include Diphtheria and tetanus toxoids and kill whole cells of organism that causes Pertusis.",
                "It is ORAL POLIO VACCINE.It protects your child against Polio,\n" +
                        "Two types available:\n" +
                        "-INACTIVE POLIO VACCINE(IPV)\n" +
                        "-ORAL POLIO VACCINE(OPV).",
                "It is MEASLES MUMPS RUBELLA(MMR),is a live attenuated viral Vaccine used to induce immunity against Measles,Mumps,and Rubella",
                "It is given to baby to prevent Typhoid Fever.",
                "It is given to baby to prevent Typhoid Fever.",
                "TD is a combination vaccine that protects your baby against three potentially diseases:\n-Tetanus\n-Diphtheria\n-Pertussis.TD is a booster vaccine for tetanus and Diphtheria.It does not protect against Pertusis.",
                "It is given to baby to prevent Typhoid Fever.",
                "It is given to baby to prevent Typhoid Fever.",
                "TD is a combination vaccine that protects your baby against three potentially diseases:\n" +
                        "-Tetanus\n" +
                        "-Diphtheria\n" +
                        "-Pertussis.TD is a booster vaccine for tetanus and Diphtheria.It does not protect against Pertusis."};
        String[] doseCount = {"(1st Dose)", "(1st Dose)", "(1st Dose)", "(2nd Dose)", "(1st Dose)", "(2nd Dose)",
                "(1st Dose)", "(2nd Dose)", "(3rd Dose)", "(2nd & 3rd Dose)", "(4th Dose)",
                "(3rd Dose)", "(3rd Dose)", "(4th Dose)", "(1st Dose)", "(1st Dose)", "(Booster Dose)",
                "(Booster Dose)", "(Booster Dose)", "(1st Dose)", "(Booster Dose)", "(Booster Dose)", "(2nd Dose)",
                "(2nd Dose)", "(3rd Dose)", "(1st Dose)", "(4th Dose)", "(5th Dose)", "(2nd Dose)"};
        int i = 0;
        Card card;
        ArrayList<Card> cards = new ArrayList<Card>();


for(i = 0;i<29;i++) {
    card = new Card(this, R.layout.carddemo_example_inner_content);

    card.setTitle(" Vaccination Date:"+monthStringvaccine.get(i)+" "+dayvaccine.get(i)+","+yearvaccine.get(i)+"\n"+" "+doseCount[i]);
    CardExpand expand = new CardExpand(this);
    expand.setTitle("Description\n" + description[i]);
    card.addCardExpand(expand);
    CardHeader header = new CardHeader(this);
    header.setTitle(vaccineName[i]);
    header.setButtonExpandVisible(true);
    card.addCardHeader(header);
    card.setupInnerViewElements(null, null);
    View child = getLayoutInflater().inflate(R.layout.xxx, null);
    CardViewNative cardView = (CardViewNative) child.findViewById(R.id.list_cardId);
    cardView.setCard(card);
    View childcheck = getLayoutInflater().inflate(R.layout.carddemo_example_inner_content, null);
    CheckBox check = (CheckBox) childcheck.findViewById(R.id.checkbox);



    cards.add(card);

}






    CardArrayAdapter mCardArrayAdapter = new CardArrayAdapter(this,cards);

    CardListView listView = (CardListView) this.findViewById(R.id.cardlist_vaccinelist);
        if (listView!=null)

    {
        listView.setAdapter(mCardArrayAdapter);
    }


}

       public void setupInnerViewElements(ViewGroup parent, View view) {


    }




    public void backButton(View view){
        Intent i = new Intent(this, MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);

    }
    public void addBaby(View view) {

        Intent i = new Intent(this, addBaby.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        Button btn = (Button) findViewById(R.id.addbaby_vaccinelist);
        btn.setBackgroundResource(R.drawable.addbabybuttonvaccinelist);
        startActivity(i);


    }



}
