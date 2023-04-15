package com.mycompany.moviebooking;

import java.io.Serializable;

public class LotteBooking implements Serializable {
    private int userid;
    private int choosedseat;
    private int movieid;

    public LotteBooking(int userid, int movieid, int choosedseat) {
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
}
