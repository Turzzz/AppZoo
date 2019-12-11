package com.example.appzoo;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentTransaction;

public class Custom_Dialog_Fragment extends DialogFragment {

    private static final String TAG = "Custom_Dialog_Fragment";
    TextView mclose,mok;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view =  inflater.inflate(R.layout.custompopup,container,false);

        mclose = view.findViewById(R.id.txtclose);
        mok=view.findViewById(R.id.btnfollow);


        mclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    getDialog().dismiss();

            }
        });

        mok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


//                List_Fragment list_fragment = (List_Fragment) getActivity().getSupportFragmentManager().findFragmentByTag("List_Fragment");
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container, new List_Fragment());
                fr.commit();
                getDialog().dismiss();
            }
        });

        return view;
    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        try{
//            mOnInputSelected = (OnInputSelected) getTargetFragment();
//        }catch (ClassCastException e){
//            Log.e(TAG, "onAttach: ClassCastException : " + e.getMessage() );
//        }
//    }
}
