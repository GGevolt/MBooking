package com.mycompany.moviebooking;

import java.io.*;
import java.util.*;
import javax.swing.*;


public class BookingController {
    ArrayList<Booking> order;
    public BookingController(){
        order = new ArrayList<Booking>();
        populateBookingArrayList();
    }

    public void populateBookingArrayList(){
        try {
            FileInputStream file1 = new FileInputStream("BookingHistory.txt");
            ObjectInputStream inputFile1 = new ObjectInputStream(file1);
            boolean endOfFile = false;
            while(!endOfFile){
                try {
                    order.add((Booking) inputFile1.readObject());
                } catch (EOFException e) {
                    endOfFile = true;
                } catch (Exception f){
                    JOptionPane.showMessageDialog(null,"Error at adding movie!");
                }
            }
            inputFile1.close();
        } catch (IOException e) {
          JOptionPane.showMessageDialog(null,"File don't exist!");
        }
    }


    public void saveTicketToFile(){
        try {
            FileOutputStream file = new FileOutputStream("BookingHistory.txt");
            ObjectOutputStream outputFile = new ObjectOutputStream(file);
            for(int i = 0; i<order.size();i++){
                outputFile.writeObject(order.get(i));
            }
            outputFile.close();
        } catch (IOException e) {
          JOptionPane.showMessageDialog(null,"File don't exist!");
        }
    }

    public int BookingCGVMovie(int selectedIndex, Object[] rowData){
        MovieController movie = new MovieController();
        AuthenticationController au = new AuthenticationController();
        int id = au.readUserId();
        for(int i =0;i<movie.cgv.size();i++){
            if(movie.cgv.get(i).getName().equals(rowData[0]) && movie.cgv.get(i).getMovieTime().equals(rowData[5]) && movie.cgv.get(i).getHalls()== (int) rowData[4]){
                int a = movie.cgv.get(i).getSeatNumber();
                int b = a - selectedIndex;
                movie.cgv.get(i).setSeatNumber(b);
                movie.saveMovieToCgvCinemaFile();
                Booking puchase =new Booking("CGV cinema",id, i, selectedIndex);
                order.add(puchase);
                saveTicketToFile();
                JOptionPane.showMessageDialog(null,"Successfully purchase ticket to "+movie.cgv.get(i).getName()+" from CGV cinema!");
                return 1;
            }
        }
        return 0;
    }


    public int BookingGalaxyMovie(int selectedIndex,  Object[] rowData){
        MovieController movie = new MovieController();
        AuthenticationController au = new AuthenticationController();
        int id = au.readUserId();
        for(int i =0;i<movie.galaxy.size();i++){
            if(movie.galaxy.get(i).getName().equals(rowData[0]) && movie.galaxy.get(i).getMovieTime().equals(rowData[5]) && movie.galaxy.get(i).getHalls()== (int) rowData[4]){
                int a = movie.galaxy.get(i).getSeatNumber();
                int b = a - selectedIndex;
                movie.galaxy.get(i).setSeatNumber(b);
                movie.saveMovieToGalaxyCinemaFile();
                Booking puchase =new Booking("Galaxy cinema",id, i, selectedIndex);
                order.add(puchase);
                saveTicketToFile();
                JOptionPane.showMessageDialog(null,"Successfully purchase ticket to "+movie.galaxy.get(i).getName()+" from Galaxy cinema!");
                return 1;
            }
        }
        return 0;
    }

    public int BookingLotteMovie(int selectedIndex, Object[] rowData ){
        MovieController movie = new MovieController();
        AuthenticationController au = new AuthenticationController();
        int id = au.readUserId();
        for(int i =0;i<movie.lotte.size();i++){
            if(movie.lotte.get(i).getName().equals(rowData[0]) && movie.lotte.get(i).getMovieTime().equals(rowData[5]) && movie.lotte.get(i).getHalls()== (int) rowData[4]){
                int a = movie.lotte.get(i).getSeatNumber();
                int b = a - selectedIndex;
                movie.lotte.get(i).setSeatNumber(b);
                movie.saveMovieToLotteCinemaFile();
                Booking puchase =new Booking("Lotte cinema",id, i, selectedIndex);
                order.add(puchase);
                saveTicketToFile();
                JOptionPane.showMessageDialog(null,"Successfully purchase ticket to "+movie.lotte.get(i).getName()+" from Lotte Cinema!");
                return 1;
            }
        }
        return 0;
    }


    public double totalprice(int num,double price){
        double p =0;
        for(int i=0;i<num;i++){
            p += price;
        }
        return p;
    }

}
