package com.example.abhujeeth.myapplicationfirebase;

/**
 * Created by abhujeeth on 7/5/17.
 */

public class FragResultsModelClass {

   private int imageid;
    private String text;


    public FragResultsModelClass(int imageid,String text)
    {
        this.imageid=imageid;
        this.text=text;
    }

    public int getImageid()
    {
        return imageid;
    }

    public String getText()
    {
        return text;
    }




}
