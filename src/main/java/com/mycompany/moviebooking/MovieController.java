package com.mycompany.moviebooking;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.*;
import java.io.*;

public class MovieController implements Serializable  {
    ArrayList<CGVcinema> cgv;
    ArrayList<Galaxycinema> galaxy;
    ArrayList<Lottecinema> lotte;
    public MovieController(){
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

    public void addmvoie(String cinema, String name, String director, int year, Double ticketPrice, Date movieTime, int seatNumber, String genre,int halls){
        String regex = ".*\\d+.*";
        if (director.matches(regex)) {
            JOptionPane.showMessageDialog(null,"Invalid input. Name cannot contain numbers.");
        }else if(ticketPrice <=0 || seatNumber <=0){
            JOptionPane.showMessageDialog(null,"Pls recheck the ticket price or seat number value!");
        }else if(cinema.equals("CGV cinema")){
            CGVcinema cgvCinema = new CGVcinema(name, year, director, genre, ticketPrice, seatNumber, halls, movieTime);
            cgv.add(cgvCinema);
            saveMovieToCgvCinemaFile();
            JOptionPane.showMessageDialog(null,"Saved Successfully to CGV cinema file!");
        }else if(cinema.equals("Galaxy cinema")){
            Galaxycinema galaxyCinema = new Galaxycinema(name, year, director, genre, ticketPrice, seatNumber, halls, movieTime);
            galaxy.add(galaxyCinema);
            saveMovieToGalaxyCinemaFile();
            JOptionPane.showMessageDialog(null,"Saved Successfully to Galaxy cinema file!");
        }else if(cinema.equals("Lotte cinama")){
            Lottecinema lotteCinema = new Lottecinema(name, year, director, genre, ticketPrice, seatNumber, halls, movieTime);
            lotte.add(lotteCinema);
            saveMovieToLotteCinemaFile();
            JOptionPane.showMessageDialog(null,"Saved Successfully to Lotte cinema file!");
        }
    }

    public void editCGVMovie(int selectedIndex, String name, String director, int year, Double ticketPrice, Date movieTime, int seatNumber, String genre,int halls ){
        cgv.get(selectedIndex).setName(name);
        cgv.get(selectedIndex).setDirector(director);
        cgv.get(selectedIndex).setGenre(genre);
        cgv.get(selectedIndex).setHalls(halls);;
        cgv.get(selectedIndex).setMovieTime(movieTime);;
        cgv.get(selectedIndex).setReleaseYear(year);;
        cgv.get(selectedIndex).setTicketPrice(ticketPrice);;
        cgv.get(selectedIndex).setSeatNumber(seatNumber);;
        saveMovieToCgvCinemaFile();
        JOptionPane.showMessageDialog(null,"Successfully edit CGV cinema file!");
    }

    public void editGalaxyMovie(int selectedIndex, String name, String director, int year, Double ticketPrice, Date movieTime, int seatNumber, String genre,int halls ){
        galaxy.get(selectedIndex).setName(name);
        galaxy.get(selectedIndex).setDirector(director);
        galaxy.get(selectedIndex).setGenre(genre);
        galaxy.get(selectedIndex).setHalls(halls);;
        galaxy.get(selectedIndex).setMovieTime(movieTime);;
        galaxy.get(selectedIndex).setReleaseYear(year);;
        galaxy.get(selectedIndex).setTicketPrice(ticketPrice);;
        galaxy.get(selectedIndex).setSeatNumber(seatNumber);;
        saveMovieToGalaxyCinemaFile();
        JOptionPane.showMessageDialog(null,"Successfully edit Galaxy cinema file!");
    }

    public void editLotteMovie(int selectedIndex, String name, String director, int year, Double ticketPrice, Date movieTime, int seatNumber, String genre,int halls ){
        lotte.get(selectedIndex).setName(name);
        lotte.get(selectedIndex).setDirector(director);
        lotte.get(selectedIndex).setGenre(genre);
        lotte.get(selectedIndex).setHalls(halls);;
        lotte.get(selectedIndex).setMovieTime(movieTime);;
        lotte.get(selectedIndex).setReleaseYear(year);;
        lotte.get(selectedIndex).setTicketPrice(ticketPrice);;
        lotte.get(selectedIndex).setSeatNumber(seatNumber);;
        saveMovieToLotteCinemaFile();
        JOptionPane.showMessageDialog(null,"Successfully edit Lotte cinema file!");
    }
}
