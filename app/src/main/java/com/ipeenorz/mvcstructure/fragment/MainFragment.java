package com.ipeenorz.mvcstructure.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ipeenorz.mvcstructure.R;

/**
 * Created by iPeenorz on 1/27/2016.
 */
public class MainFragment extends Fragment{

    int sumVar ;
    int x, y, z ;
    TextView tvHello ;

    public static MainFragment newInstance(int sumVar){
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putInt("sumVar",sumVar);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sumVar = getArguments().getInt("sumVar");


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

      View rootview = inflater.inflate(R.layout.fragment_main,container,false);

        initInstance(rootview);

        return rootview;
    }

    private void initInstance(View rootview) {

        tvHello = (TextView)rootview.findViewById(R.id.tvHello);

    }

    public void setHelloText (String text){
        tvHello.setText(text);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(savedInstanceState !=null){
            //Restore State

        }
    }
}
