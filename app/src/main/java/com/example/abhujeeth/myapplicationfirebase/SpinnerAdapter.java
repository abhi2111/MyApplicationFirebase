package com.example.abhujeeth.myapplicationfirebase;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by abhujeeth on 7/4/17.
 */

public class SpinnerAdapter extends ArrayAdapter {

    Context context;
    List<SpinnerModelClass>objs;


    public SpinnerAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);

        this.context=context;
        this.objs=objects;


    }

    public int getCount()
    {
        return objs.size();
    }


    public SpinnerModelClass getItem(int position){
        return objs.get(position);
    }

    public long getItemId(int position){
        return position;
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView view = new TextView(context);
        view.setTextColor(Color.BLACK);
        view.setGravity(Gravity.CENTER);
        view.setText(objs.get(position).getClassnumber());

        return view;
    }

    public View getDropDownView(int position, View convertView,
                                ViewGroup parent) {
       final TextView view = new TextView(context);
        view.setTextColor(Color.BLACK);
        view.setText(objs.get(position).getClassnumber());
        view.setHeight(60);
        view.setBackgroundColor(context.getResources().getColor(R.color.cardview_light_background));
        view.setGravity(Gravity.CENTER);

        return view;
    }
}
