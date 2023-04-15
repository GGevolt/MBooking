package com.mycompany.moviebooking.Controller;

import java.io.*;
import java.util.*;
import javax.swing.*;

import com.mycompany.moviebooking.Model.CGVBooking;
import com.mycompany.moviebooking.Model.GalaxyBooking;
import com.mycompany.moviebooking.Model.LotteBooking;

public class BookingController {
    public ArrayList<CGVBooking> cgvOrder;
    public ArrayList<GalaxyBooking> galaxyOrder;
    public ArrayList<LotteBooking> lotteOrder;
    public BookingController(){
        cgvOrder = new ArrayList<CGVBooking>();
        galaxyOrder = new ArrayList<GalaxyBooking>();
        lotteOrder = new ArrayList<LotteBooking>();
        populateBookingArrayList();
    }

    public void populateBookingArrayList(){
        try {
            FileInputStream file = new FileInputStream("CGVBooking.txt");
            ObjectInputStream inputFile = new ObjectInputStream(file);
            boolean endOfFile = false;
            while(!endOfFile){
                try {
                    cgvOrder.add((CGVBooking) inputFile.readObject());
                } catch (EOFException e) {
                    endOfFile = true;
                } catch (Exception f){
                    JOptionPane.showMessageDialog(null,"Error at adding movie!");
                }
            }
            inputFile.close();
        } catch (IOException e) {
          JOptionPane.showMessageDialog(null,"File don't exist!");
        }
        try {
            FileInputStream file1 = new FileInputStream("GalaxyBooking.txt");
            ObjectInputStream inputFile1 = new ObjectInputStream(file1);
            boolean endOfFile = false;
            while(!endOfFile){
                try {
                    galaxyOrder.add((GalaxyBooking) inputFile1.readObject());
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
        try {
            FileInputStream file2 = new FileInputStream("LotteBooking.txt");
            ObjectInputStream inputFile2 = new ObjectInputStream(file2);
            boolean endOfFile = false;
            while(!endOfFile){
                try {
                    lotteOrder.add((LotteBooking) inputFile2.readObject());
                } catch (EOFException e) {
                    endOfFile = true;
                } catch (Exception f){
                    JOptionPane.showMessageDialog(null,"Error at adding movie!");
                }
            }
            inputFile2.close();
        } catch (IOException e) {
          JOptionPane.showMessageDialog(null,"File don't exist!");
        }
    }

    public void saveTicketToCgvCinemaFile(){
        try {
            FileOutputStream file = new FileOutputStream("CGVBooking.txt");
            ObjectOutputStream outputFile = new ObjectOutputStream(file);
            for(int i = 0; i<cgvOrder.size();i++){
                outputFile.writeObject(cgvOrder.get(i));
            }
            outputFile.close();
        } catch (IOException e) {
          JOptionPane.showMessageDialog(null,"File don't exist!");
        }
    }

    public void saveTicketToGalaxyCinemaFile(){
        try {
            FileOutputStream file = new FileOutputStream("GalaxyBooking.txt");
            ObjectOutputStream outputFile = new ObjectOutputStream(file);
            for(int i = 0; i<galaxyOrder.size();i++){
                outputFile.writeObject(galaxyOrder.get(i));
            }
            outputFile.close();
        } catch (IOException e) {
          JOptionPane.showMessageDialog(null,"File don't exist!");
        }
    }

    public void saveTicketToLotteCinemaFile(){
        try {
            FileOutputStream file = new FileOutputStream("LotteBooking.txt");
            ObjectOutputStream outputFile = new ObjectOutputStream(file);
            for(int i = 0; i<lotteOrder.size();i++){
                outputFile.writeObject(lotteOrder.get(i));
            }
            outputFile.close();
        } catch (IOException e) {
          JOptionPane.showMessageDialog(null,"File don't exist!");
        }
    }

    public double totalprice(int num,double price){
        double p =0;
        for(int i=0;i<num;i++){
            p += price;
        }
        return p;
    }


}
