package com.example.abhujeeth.myapplicationfirebase;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;


public class FragmentResults extends Fragment {

    List<SpinnerModelClass> obj;
    Spinner spinner;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_results, container, false);


      //  String[] values ={"Select class", "VII", "VIII", "IX", "X", "XI", "XII", "Competition",};
        spinner = (Spinner) view.findViewById(R.id.spinner);
       // spinner.getBackground().setColorFilter(getResources().getColor(R.color.cardview_dark_background), PorterDuff.Mode.SRC_ATOP);

        createObjects();

       // ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, values);
       // adapter.setDropDownViewResource(android.R.layout.simple_expandable_list_item_1);
       // spinner.setAdapter(adapter);

        return view;


    }

    private void createObjects() {

        SpinnerAdapter adapter=new SpinnerAdapter(getActivity(),R.layout.support_simple_spinner_dropdown_item,listObjects());
        spinner.setAdapter(adapter);




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


}
