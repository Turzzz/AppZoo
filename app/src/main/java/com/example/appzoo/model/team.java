package com.example.appzoo.model;

public class team {

    private int id;
    private String title;
    private int imageRes ;
    private int age;
    private String team_name;

    public team() {
    }

    public team(int id, String title, int imageRes, int age, String team_name) {
        this.id = id;
        this.title = title;
        this.imageRes = imageRes;
        this.age = age;
        this.team_name = team_name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageRes() {
        return imageRes;
    }

    public void setImageRes(int imageRes) {
        this.imageRes = imageRes;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
