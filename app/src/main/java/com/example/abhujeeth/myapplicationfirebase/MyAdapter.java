package com.example.abhujeeth.myapplicationfirebase;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by abhujeeth on 6/30/17.
 */

public class MyAdapter extends RecyclerView.Adapter <MyAdapter.MyViewHolder>{

    List<ModelClass> objs;
    Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView;
        TextView textView;

        public MyViewHolder(View view)
        {
            super(view);
            imageView=(ImageView)view.findViewById(R.id.imageView);
            imageView.setOnClickListener(this);
            textView=(TextView)view.findViewById(R.id.textView);


        }


        @Override
        public void onClick(View v) {
            AppCompatActivity activity = (AppCompatActivity) v.getContext();
            Fragment myFragment = new FragmentResults();
            activity.getSupportFragmentManager().beginTransaction().replace(R.id.activity_main, myFragment).addToBackStack(null).commit();

        }
    }

    public MyAdapter(Context context, List objs)
    {
        this.context=context;
        this.objs=objs;
    }



    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleritems,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyAdapter.MyViewHolder holder, int position) {
        ModelClass obj=objs.get(position);
        holder.textView.setText(obj.getText());
        holder.imageView.setImageResource(obj.getImageid());

    }

    @Override
    public int getItemCount() {
        return objs.size();
    }
}
