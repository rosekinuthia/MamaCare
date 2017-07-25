package com.mamacare.mamacare;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;


public class Faclity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faclity);
        MaterialBetterSpinner spinner =(MaterialBetterSpinner)findViewById(R.id.spinner);
        ArrayList<String> items=getfacility("kmfl.json");
        ArrayAdapter<String> adapter =new ArrayAdapter<String>(this,R.layout.spinner_layout,R.id.text,items);
        spinner.setAdapter(adapter);

    }

    public ArrayList<String> getfacility(String filename){
        JSONArray jsonArray=null;
        ArrayList<String> facilitylist= new ArrayList<String>();

        try {
            InputStream is =getResources().getAssets().open(filename);
            int size = is.available();

            byte[] data= new byte[size];
            is.read(data);
            is.close();
            String json=new String(data,"UTF-8");
            jsonArray=new JSONArray(json);
            if(jsonArray!=null){
                for(int i=1;i<jsonArray.length();i++){
                    facilitylist.add(jsonArray.getJSONObject(i).getString("FIELD2"));
                }
            }

        }catch (IOException e){e.printStackTrace();}
        catch (JSONException e){e.printStackTrace();}

        return facilitylist;


    }
}
