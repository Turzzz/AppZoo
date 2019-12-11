package com.example.appzoo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class Information_Fragment extends DialogFragment {

    private static final String TAG = "Information_Fragment";
    //   public static TextView mfirst;
    public TextView mInputDisplay;
    TextView mclose, mok;
//     Information_Fragment information_fragment =new Information_Fragment();


//    public void sendInput(String input) {
//        mInputDisplay.setText(input);
//    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.registration_information, container, false);

        mclose = view.findViewById(R.id.txtclose);
        mok = view.findViewById(R.id.btnfollow);
//        mInputDisplay=view.findViewById(R.id.input_fname);


        Bundle bundle = getArguments();
        String fname;

        try {
           fname = bundle.getString("First Name : ");
            mInputDisplay = view.findViewById(R.id.input_fname);
            mInputDisplay.setText(fname);
        } catch (NullPointerException e) {
        }


        mclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getDialog().dismiss();

            }
        });

        mok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });

        return view;
    }


}
