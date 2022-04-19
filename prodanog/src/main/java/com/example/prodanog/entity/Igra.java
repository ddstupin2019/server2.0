package com.example.prodanog.entity;

import java.util.ArrayList;

public class Igra {
    private Integer play1,play2,play3,play4,play5,play6,maxPlayer,playerShod=1;
    private ArrayList<Integer> nedcol,moneycol;
    private Boolean status;
    static private Integer id;

    public Integer getPlayerShod() {
        return playerShod;
    }

    public void setPlayerShod(Integer playerShod) {
        this.playerShod = playerShod;
    }

    public Integer getMaxPlayer() {
        return maxPlayer;
    }

    public void setMaxPlayer(Integer maxPlayer) {
        this.maxPlayer = maxPlayer;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public static Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPlay1() {
        return play1;
    }

    public void setPlay1(Integer play1) {
        this.play1 = play1;
    }

    public Integer getPlay2() {
        return play2;
    }

    public void setPlay2(Integer play2) {
        this.play2 = play2;
    }

    public Integer getPlay3() {
        return play3;
    }

    public void setPlay3(Integer play3) {
        this.play3 = play3;
    }

    public Integer getPlay4() {
        return play4;
    }

    public void setPlay4(Integer play4) {
        this.play4 = play4;
    }

    public Integer getPlay5() {
        return play5;
    }

    public void setPlay5(Integer play5) {
        this.play5 = play5;
    }

    public Integer getPlay6() {
        return play6;
    }

    public void setPlay6(Integer play6) {
        this.play6 = play6;
    }

    public ArrayList<Integer> getNedcol() {
        return nedcol;
    }

    public void setNedcol(ArrayList<Integer> nedcol) {
        this.nedcol = nedcol;
    }

    public ArrayList<Integer> getMoneycol() {
        return moneycol;
    }

    public void setMoneycol(ArrayList<Integer> moneycol) {
        this.moneycol = moneycol;
    }

    public Integer addPlayr(int id){
        if (play1==null){
            play1=id;
            return 1;
        }
        if (play2==null){
            play2=id;
            return 2;
        }
        if (play3==null){
            play3=id;
            return 3;
        }
        if (play4==null){
            play4=id;
            return 4;
        }
        if (play5==null){
            play5=id;
            return 5;
        }
        if (play6==null){
            play6=id;
            return 6;
        }
        return 0;
    }
    public static ArrayList<Integer> coloda() {
        ArrayList<Integer> sd = new ArrayList<>();
        final Integer max = 30, min = 1;
        for (int i = 0; i < 30; i++) {
            Integer a = (int) (Math.random() * ((max - min) + 1)) + min;
            while (true) {
                if (ty(a, sd)) {
                    a = (int) (Math.random() * ((max - min) + 1)) + min;
                } else {
                    sd.add(a);
                    break;
                }
            }
        }
        return sd;
    }
    public static boolean ty(int a, ArrayList<Integer> sd){
        for (int i = 0; i < sd.size(); i++) {
            if (sd.get(i)==a){
                return true;
            }
        }
        return false;
    }
    public Integer playerShodi(){
        if (playerShod==maxPlayer-1){
            playerShod=1;
        }else {
            playerShod++;
        }
        return playerShod;
    }
}
