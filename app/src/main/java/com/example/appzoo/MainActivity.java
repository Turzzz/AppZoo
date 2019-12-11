package com.example.appzoo;

import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appzoo.adapter.TeamAdapter;
import com.example.appzoo.model.team;
import com.example.appzoo.utils.DataGenerator;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class MainActivity extends AppCompatActivity {



    Toolbar toolbar;

    //    private TabLayout tabLayout;
//    private ViewPager viewPager;
//    private ViewPageAdapter adapeter;
    RecyclerView recyclerView;
    TeamAdapter adapter;

    Switch aSwitch;
    private CameraManager mCameraManager;
    private String mCameraId;


    //BottomNavigationView
    private BottomNavigationView.OnNavigationItemSelectedListener navlistner =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {


//                        case R.id.homeID:
//                            selectedFragment = new Home_Fragment();
//                            break;

                        case R.id.login_id:
                            selectedFragment = new Login_Fragment();
                            break;

                        case R.id.registration_id:
                            selectedFragment = new Register_Fragment();
                            break;

//                        case R.id.list_id:
//                            selectedFragment = new List_Fragment();
//                            break;


                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();

                    return true;
                }
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Toolbar
        toolbar = findViewById(R.id.toolbar_SS);
        setSupportActionBar(toolbar);


        //RecycleView

        recyclerView = findViewById(R.id.recylerView);

        final List<team> teamList = DataGenerator.getteams();
        adapter = new TeamAdapter(teamList, this);
        recyclerView.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter.setAdapterListener(new TeamAdapter.adapterListener() {
            @Override
            public void onIteamClick(int position) {
                team team = teamList.get(position);
                Toast.makeText(MainActivity.this, "" + team.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });

        //BottomNavigationView
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navlistner);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new Home_Fragment()).commit();

//            "TABLAYOUT"
//        tabLayout =findViewById(R.id.tabLayout_id);
//        viewPager=findViewById(R.id.viewPager_id);
//
//
//        adapeter = new ViewPageAdapter(getSupportFragmentManager());
//
//
//        adapeter.AddFragement(new FragmentCall(),"Call");
//        adapeter.AddFragement(new FragmentRegister(),"Contact");
//        adapeter.AddFragement(new FragmentSignup(),"Fav");
//
//
//        viewPager.setAdapter(adapeter);
//        tabLayout.setupWithViewPager(viewPager);


        //Fragement

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, new Login_Fragment());
        fragmentTransaction.commit();


        // "Switch && Flash
//        aSwitch = findViewById(R.id.action_switch);
//        try {
//            aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//                @RequiresApi(api = Build.VERSION_CODES.M)
//                @Override
//
//                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//
//
//                    if (isChecked == true) {
//                        switchFlashLight(isChecked);
//                        Toast.makeText(getBaseContext(), "fLASHlIGHT", Toast.LENGTH_SHORT).show();
//                    } else {
//                        switchFlashLight(false);
//                        Toast.makeText(getBaseContext(), "dont work", Toast.LENGTH_SHORT).show();
//                    }
//
//
//                }
//            });
//        } catch (NullPointerException e) {
//        }
//
//
//        boolean isFlashAvailable = getApplicationContext().getPackageManager()
//                .hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
//
//        if (!isFlashAvailable) {
//            showNoFlashError();
//        }
//
//
//        mCameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
//        try {
//            mCameraId = mCameraManager.getCameraIdList()[0];
//        } catch (
//                CameraAccessException e) {
//            e.printStackTrace();
//        }


    }

    // "Switch && Flash
//    public void showNoFlashError() {
//        AlertDialog alert = new AlertDialog.Builder(this)
//                .create();
//        alert.setTitle("Oops!");
//        alert.setMessage("Flash not available in this device...");
//        alert.setButton(DialogInterface.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialog, int which) {
//                finish();
//            }
//        });
//        alert.show();
//    }
//
//    @RequiresApi(api = Build.VERSION_CODES.M)
//    public void switchFlashLight(boolean status) {
//        try {
//            mCameraManager.setTorchMode(mCameraId, status);
//        } catch (CameraAccessException e) {
//            e.printStackTrace();
//        }
//    }


    //searchview
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.search_action);
        SearchView searchView = (SearchView) searchItem.getActionView();

        MenuItem switchItem = menu.findItem(R.id.switch_id);
        Switch aSwitch = (Switch) switchItem.getActionView();


        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                adapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }


}
