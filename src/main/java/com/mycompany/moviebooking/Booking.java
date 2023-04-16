package com.mycompany.moviebooking;

import java.io.Serializable;

public class Booking implements Serializable {
    private String cinema;
    private int userid;
    private int choosedseat;
    private int movieid;

    public Booking(String cinema,int userid, int movieid, int choosedseat) {
        this.cinema = cinema;
        this.userid = userid;
        this.movieid = movieid;
        this.choosedseat = choosedseat;
    }

    public int getUserid(){
        return userid;
    }

    public void setUserid(int userid){
        this.userid = userid;
    }


    public int getChoosedseat() {
        return choosedseat;
    }

    public void setChoosedseat(int choosedseat) {
        this.choosedseat = choosedseat;
    }

    public int getMovieid() {
        return movieid;
    }

    public void setMovieid(int movieid) {
        this.movieid = movieid;
    }

    public String getCinema() {
        return cinema;
    }

    public void setCinema(String cinema) {
        this.cinema = cinema;
    }
}
