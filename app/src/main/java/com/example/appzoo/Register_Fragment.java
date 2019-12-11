package com.example.appzoo;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.loopeer.shadow.ShadowView;

public class Register_Fragment extends Fragment {

    public OnInputSelected minputselected;
    AutoCompleteTextView fname, lname, email;
    String fstring, lstring, estring;
    TextView regtologF;
    public ShadowView btn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.registration_fragment, container, false);

        btn=view.findViewById(R.id.btnlogin_sview);
        regtologF = view.findViewById(R.id.regtolog);
        fname = view.findViewById(R.id.first_name);
//         lname = view.findViewById(R.id.last_name);



        regtologF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FragmentTransaction fr = getFragmentManager().beginTransaction();
                    fr.replace(R.id.fragment_container, new Login_Fragment());
                    fr.commit();
                }
                catch (NullPointerException expres){}
            }
        });


    btn.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            Information_Fragment information_fragment = new Information_Fragment();
            information_fragment.show(getFragmentManager(), "Information_Fragment");

            Bundle bundle =new Bundle();
            fstring = fname.getText().toString();
            bundle.putString("First Name : ",fstring);
            information_fragment.setArguments(bundle);
//            try{
//                if (!fstring.equals("")) {
//
//                    Toast.makeText(getContext(), fstring, Toast.LENGTH_SHORT).show();
////                   Information_Fragment.mfirst.setText(fstring);
//                   minputselected.sendInput(fstring);
//                }
//
//
//            }
//               catch(NullPointerException exception){}



        }
    });






        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            minputselected = (OnInputSelected) getTargetFragment();
        } catch (ClassCastException e) {
        }
    }

    public interface OnInputSelected {
        void sendInput(String fstring);
    }


}
