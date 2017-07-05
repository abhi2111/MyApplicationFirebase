package com.example.abhujeeth.myapplicationfirebase;

/**
 * Created by abhujeeth on 7/5/17.
 */

public class FragResultsModelClass {

   private int imageid;
    private String text;
    private String admitclas;


    public FragResultsModelClass(int imageid,String text,String admitclass)
    {
        this.imageid=imageid;
        this.text=text;
        this.admitclas=admitclass;
    }

    public int getImageid()
    {
        return imageid;
    }

    public String getText()
    {
        return text;
    }

    public String getAdmitclas()
    {
        return admitclas;
    }



}
