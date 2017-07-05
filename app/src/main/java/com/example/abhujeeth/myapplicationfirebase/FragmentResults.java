package com.example.abhujeeth.myapplicationfirebase;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Filter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;


public class FragmentResults extends Fragment implements Spinner.OnItemSelectedListener{

    List<SpinnerModelClass> obj;
    Spinner spinner;
    RecyclerView recyclerView;
    List<FragResultsModelClass> objs;
    SpinnerAdapter adapter;
    RecyclerFragResultsAdapter adapterone;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_results, container, false);


      //  String[] values ={"Select class", "VII", "VIII", "IX", "X", "XI", "XII", "Competition",};
        spinner = (Spinner) view.findViewById(R.id.spinner);
       // spinner.getBackground().setColorFilter(getResources().getColor(R.color.cardview_dark_background), PorterDuff.Mode.SRC_ATOP);

        recyclerView=(RecyclerView)view.findViewById(R.id.recyclerviewone);

        createObjects();

        createRecyclerView(view);
        recyclerObjs();

       // ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, values);
       // adapter.setDropDownViewResource(android.R.layout.simple_expandable_list_item_1);
       // spinner.setAdapter(adapter);

        return view;


    }

    private void createRecyclerView(View view) {


        recyclerView=(RecyclerView)view.findViewById(R.id.recyclerviewone);
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);



    }

    private void recyclerObjs()
    {
        objs=new ArrayList<>();

        FragResultsModelClass objone=new FragResultsModelClass(R.drawable.admission,"physics","VIII");
        objs.add(objone);

        FragResultsModelClass objtwo=new FragResultsModelClass(R.drawable.admission,"physics","VIII");
        objs.add(objtwo);

        FragResultsModelClass objthree=new FragResultsModelClass(R.drawable.admission,"physics","VII");
        objs.add(objthree);

        FragResultsModelClass objfour=new FragResultsModelClass(R.drawable.admission,"physics","XI");
        objs.add(objfour);

        FragResultsModelClass objfive=new FragResultsModelClass(R.drawable.admission,"physics","XI");
        objs.add(objfive);

        FragResultsModelClass objsix=new FragResultsModelClass(R.drawable.admission,"physics","XI");
        objs.add(objsix);

        FragResultsModelClass objseven=new FragResultsModelClass(R.drawable.admission,"physics","X");
        objs.add(objseven);

        adapterone=new RecyclerFragResultsAdapter(getActivity(),objs);
        recyclerView.setAdapter(adapterone);
    }



    private void createObjects() {

         adapter=new SpinnerAdapter(getActivity(),R.layout.support_simple_spinner_dropdown_item,listObjects());
        spinner.setAdapter(adapter);
       spinner.setOnItemSelectedListener(this);






    }

    private List listObjects() {

        obj=new ArrayList<>();
        SpinnerModelClass objone=new SpinnerModelClass("Select class");
        obj.add(objone);
        SpinnerModelClass objtwo=new SpinnerModelClass("VII");
        obj.add(objtwo);
        SpinnerModelClass objthree=new SpinnerModelClass("VIII");
        obj.add(objthree);
        SpinnerModelClass objfour=new SpinnerModelClass("IX");
        obj.add(objfour);
        SpinnerModelClass objfive=new SpinnerModelClass("X");
        obj.add(objfive);
        SpinnerModelClass objsix=new SpinnerModelClass("XI");
        obj.add(objsix);
        SpinnerModelClass objseven=new SpinnerModelClass("XII");
        obj.add(objseven);
        SpinnerModelClass objeight=new SpinnerModelClass("Competition");
        obj.add(objeight);

        return obj;

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        SpinnerModelClass city = adapter.getItem(position);
        Log.d("tag","false");

        adapterone.getFilter().filter(city.getClassnumber(),new Filter.FilterListener(){

            @Override
            public void onFilterComplete(int count) {
                Log.d("tag","true");

            }
        });
    }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }



}
