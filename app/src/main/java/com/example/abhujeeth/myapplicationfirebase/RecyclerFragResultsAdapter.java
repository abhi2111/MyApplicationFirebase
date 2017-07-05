package com.example.abhujeeth.myapplicationfirebase;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by abhujeeth on 7/4/17.
 */

public class RecyclerFragResultsAdapter extends RecyclerView.Adapter<RecyclerFragResultsAdapter.MyViewHolder> {



   public class MyViewHolder extends RecyclerView.ViewHolder {

       TextView text;ImageView image;

       public MyViewHolder(View itemView) {
           super(itemView);
            text=(TextView)itemView.findViewById(R.id.textView12);
            image=(ImageView)itemView.findViewById(R.id.imageView4);
       }

   }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.fragresultcard,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        

    }



    @Override
    public int getItemCount() {
        return 0;
    }



}
