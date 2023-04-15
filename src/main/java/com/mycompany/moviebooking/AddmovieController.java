package com.mycompany.moviebooking;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import javax.swing.*;
<<<<<<< HEAD:src/main/java/com/mycompany/moviebooking/Controller/AddmovieController.java

import com.mycompany.moviebooking.Model.CGVcinema;
import com.mycompany.moviebooking.Model.Galaxycinema;
import com.mycompany.moviebooking.Model.Lottecinema;

=======
>>>>>>> parent of 255df50 (MVC):src/main/java/com/mycompany/moviebooking/AddmovieController.java
import java.io.*;

public class AddmovieController implements Serializable  {
    ArrayList<CGVcinema> cgv;
    ArrayList<Galaxycinema> galaxy;
    ArrayList<Lottecinema> lotte;
    public AddmovieController(){
        cgv = new ArrayList<CGVcinema>();
        galaxy = new ArrayList<Galaxycinema>();
        lotte = new ArrayList<Lottecinema>();
        populateArrayList();
    }
    public void populateArrayList(){
        try {
            FileInputStream file = new FileInputStream("CGVcinema.txt");
            ObjectInputStream inputFile = new ObjectInputStream(file);
            boolean endOfFile = false;
            while(!endOfFile){
                try {
                    cgv.add((CGVcinema) inputFile.readObject());
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
            FileInputStream file1 = new FileInputStream("Galaxycinema.txt");
            ObjectInputStream inputFile1 = new ObjectInputStream(file1);
            boolean endOfFile = false;
            while(!endOfFile){
                try {
                    galaxy.add((Galaxycinema) inputFile1.readObject());
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
            FileInputStream file2 = new FileInputStream("LotteCinema.txt");
            ObjectInputStream inputFile2 = new ObjectInputStream(file2);
            boolean endOfFile = false;
            while(!endOfFile){
                try {
                    lotte.add((Lottecinema) inputFile2.readObject());
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

    public void saveMovieToCgvCinemaFile(){
        try {
            FileOutputStream file = new FileOutputStream("CGVcinema.txt");
            ObjectOutputStream outputFile = new ObjectOutputStream(file);
            for(int i = 0; i<cgv.size();i++){
                outputFile.writeObject(cgv.get(i));
            }
            outputFile.close();
        } catch (IOException e) {
          JOptionPane.showMessageDialog(null,"File don't exist!");
        }
    }



    public void saveMovieToGalaxyCinemaFile(){
        try {
            FileOutputStream file = new FileOutputStream("Galaxycinema.txt");
            ObjectOutputStream outputFile = new ObjectOutputStream(file);
            for(int i = 0; i<galaxy.size();i++){
                outputFile.writeObject(galaxy.get(i));
            }
            outputFile.close();
        } catch (IOException e) {
          JOptionPane.showMessageDialog(null,"File don't exist!");
        }
    }



    public void saveMovieToLotteCinemaFile(){
        try {
            FileOutputStream file = new FileOutputStream("LotteCinema.txt");
            ObjectOutputStream outputFile = new ObjectOutputStream(file);
            for(int i = 0; i<lotte.size();i++){
                outputFile.writeObject(lotte.get(i));
            }
            outputFile.close();
        } catch (IOException e) {
          JOptionPane.showMessageDialog(null,"File don't exist!");
        }
    }



}
