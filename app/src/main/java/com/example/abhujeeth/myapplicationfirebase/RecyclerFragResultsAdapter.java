package com.example.abhujeeth.myapplicationfirebase;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abhujeeth on 7/4/17.
 */

public class RecyclerFragResultsAdapter extends RecyclerView.Adapter<RecyclerFragResultsAdapter.MyViewHolder> implements Filterable {

    Context context;
    List<FragResultsModelClass> objs;
    private List<FragResultsModelClass> addressFilterList;

    private AddressFilter addressFilter;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView text;
        ImageView image;

        public MyViewHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.textView12);
            image = (ImageView) itemView.findViewById(R.id.imageView4);
        }

    }

    public RecyclerFragResultsAdapter(Context context, List objs) {
        this.context = context;
        this.objs = objs;
        this.addressFilterList = objs;

    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragresultcard, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        FragResultsModelClass obj = objs.get(position);
        holder.text.setText(obj.getText());
        holder.image.setImageResource(obj.getImageid());

    }


    @Override
    public int getItemCount() {
        return objs.size();
    }


    @Override
    public Filter getFilter() {


        if (addressFilter == null) {
            addressFilter = new AddressFilter();
        }
        return addressFilter;
    }


    private class AddressFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

//below checks the match for the cityId and adds to the filterlist
            String cityId = constraint.toString();
            FilterResults results = new FilterResults();

            if (cityId!=null) {
                ArrayList<FragResultsModelClass> filterList = new ArrayList<>();
                for (int i = 0; i < addressFilterList.size(); i++) {


                    if ((addressFilterList.get(i).getAdmitclas()).equals(cityId)){

                        FragResultsModelClass address = addressFilterList.get(i);
                        filterList.add(address);
                    }
                }

                results.count = filterList.size();
                results.values = filterList;

            } else {

                results.count = addressFilterList.size();
                results.values = addressFilterList;

            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            objs = (ArrayList<FragResultsModelClass>)results.values;
            notifyDataSetChanged();

        }


    }
}
