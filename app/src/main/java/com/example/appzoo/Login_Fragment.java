package com.example.appzoo;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.loopeer.shadow.ShadowView;



public class Login_Fragment extends Fragment {

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TEXT = "text";
    public static final String PASS = "pass";

    AutoCompleteTextView login_email;
    EditText login_password;
    private TextView forgetpassdialog,loginbutton;
    String text,pass;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_fragment, container, false);


        TextView ltor = view.findViewById(R.id.logintoreg);
        TextView logintopass = view.findViewById(R.id.forgetpass);

        ltor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container, new Register_Fragment());
                fr.commit();
            }
        });

        logintopass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container, new Register_Fragment());
                fr.commit();
            }
        });

        forgetpassdialog = view.findViewById(R.id.forgetpass);
        forgetpassdialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Forget_Password_Dialog_Fragment forget_password_dialog_fragment = new Forget_Password_Dialog_Fragment();
                forget_password_dialog_fragment.show(getFragmentManager(), "Forget_Password_Dialog_");

            }
        });

        loginbutton=view.findViewById(R.id.login_id_layout);
        login_email=view.findViewById(R.id.email);
        login_password=view.findViewById(R.id.password);
        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    if(login_email.getText().toString().equals("admin") && login_password.getText().toString().equals("admin")) {
                        FragmentTransaction fr = getFragmentManager().beginTransaction();
                        fr.replace(R.id.fragment_container, new List_Fragment());
                        fr.commit();

                        saveData();
                    }

                    else{
                        Toast.makeText(getContext(), "Wrong User Name Or Wrong Password", Toast.LENGTH_SHORT).show();
                    }
            }
        });


        loadData();
        updateViews();



        return view;

    }

    public void saveData() {
        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(TEXT, login_email.getText().toString());
        editor.putString(PASS, login_password.getText().toString());

        editor.apply();
    }

    public void loadData() {
        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        text = sharedPreferences.getString(TEXT, "");
        pass = sharedPreferences.getString(PASS, "");
    }

    public void updateViews() {
        login_email.setText(text);
        login_password.setText(pass);
    }


}
