package com.example.appzoo.utils;


import com.example.appzoo.R;
import com.example.appzoo.model.team;


import java.util.ArrayList;
import java.util.List;

public class DataGenerator {

    public static List<team> getteams(){

        List<team> teamList = new ArrayList<>();
//        team team = new team(1,"Isco", R.drawable.isco,29,"Spain");
//        teamList.add(team);

        teamList.add(new team(1,"Isco", R.drawable.isco,29,"Spain"));
        teamList.add(new team(2,"Kaka", R.drawable.kaka,35,"Brazil"));
        teamList.add(new team(3,"Vardy", R.drawable.vardy,29,"England"));
        teamList.add(new team(4,"Zlatan", R.drawable.zlatan,35,"Sweden"));
        teamList.add(new team(5, "Neymar", R.drawable.neymar, 29, "Brazil"));
        teamList.add(new team(6,"Rolando", R.drawable.rolando,33,"Portugal"));
        teamList.add(new team(7, "Messi", R.drawable.messi, 31, "Argentina"));

    

        return teamList;


    }
}
