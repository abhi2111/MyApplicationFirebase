package com.example.abhujeeth.myapplicationfirebase;

/**
 * Created by abhujeeth on 6/30/17.
 */

public class ModelClass {
    String text;
    int imageid;

    public ModelClass(String text,int imageid)
    {
        this.text=text;
        this.imageid=imageid;
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
