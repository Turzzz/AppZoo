package com.example.appzoo;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class  Home_Fragment extends Fragment {


    private static final String TAG = "Home_Fragment";
    private Button mOpernDialog;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_home,container,false);

//        Button btn =view.findViewById(R.id.dropboz);
//
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                FragmentTransaction fr = getFragmentManager().beginTransaction();
//                fr.replace(R.id.fragment_container, new Register_Fragment());
//                fr.commit();
//
//            }
//        });


         mOpernDialog =view.findViewById(R.id.dropboz);
         mOpernDialog.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 Custom_Dialog_Fragment dialog_fragment = new Custom_Dialog_Fragment();
                 dialog_fragment.show(getFragmentManager(),"Custom_Dialog_Fragment");

             }
         });

        return view;

    }

}
