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



    public double totalprice(int num,double price){
        double p =0;
        for(int i=0;i<num;i++){
            p += price;
        }
        return p;
    }

}
