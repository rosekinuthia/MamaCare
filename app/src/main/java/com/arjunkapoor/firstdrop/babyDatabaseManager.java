package com.arjunkapoor.firstdrop;

import java.sql.Date;

/**
 * Created by ARJUN on 3/19/2016.
 */
public class babyDatabaseManager {

    //private variables
    int _id;
    String _name;
    String _dateofbirth;
    String _gender;


    public babyDatabaseManager(){

    }

    public babyDatabaseManager(int id, String name, String _dateofbirth,String _gender){
        this._id = id;
        this._name = name;
        this._dateofbirth = _dateofbirth;
        this._gender = _gender;
    }


    public babyDatabaseManager(String name, String _dateofbirth,String _gender){
        this._name = name;
        this._dateofbirth = _dateofbirth;
        this._gender = _gender;
    }

    public int getID(){
        return this._id;
    }


    public void setID(int id){
        this._id = id;
    }


    public String getName(){
        return this._name;
    }


    public void setName(String name){
        this._name = name;
    }


    public String getdateofbirth(){
        return this._dateofbirth;
    }



    public void setdateofbirth(String dateofbirth){
        this._dateofbirth = dateofbirth;
    }
    public void setgender(String gender){
        this._gender = gender;
    }
    public String getgender(){
        return this._gender;
    }
}
