package com.example.prodanog.entity;

import java.util.ArrayList;

public class Player {
    static private Integer id,stavka,balance,maxPlayer;
    private ArrayList<Integer> nedcol,moncol;
    private String name;

    public Integer getMaxPlayer() {
        return maxPlayer;
    }

    public void setMaxPlayer(Integer maxPlayer) {
        this.maxPlayer = maxPlayer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStavka() {
        return stavka;
    }

    public void setStavka(Integer stavka) {
        this.stavka = stavka;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public ArrayList<Integer> getNedcol() {
        return nedcol;
    }

    public void setNedcol(ArrayList<Integer> nedcol) {
        this.nedcol = nedcol;
    }

    public ArrayList<Integer> getMoncol() {
        return moncol;
    }

    public void setMoncol(ArrayList<Integer> moncol) {
        this.moncol = moncol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMon(){
        Integer rez=0;
        for (int i = 0; i < moncol.size(); i++) {
            rez+=moncol.get(i);
        }
        return rez;
    }
}
