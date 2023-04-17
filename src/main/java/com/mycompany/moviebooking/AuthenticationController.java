package com.mycompany.moviebooking;

import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;
import java.io.*;

public class AuthenticationController implements Serializable {
    ArrayList<Account> accounts;
    public AuthenticationController(){
        accounts = new ArrayList<Account>();
        populateAccountArrayList();
    }
    public void populateAccountArrayList(){
        try {
            FileInputStream file = new FileInputStream("Registration.txt");
            ObjectInputStream inputFile = new ObjectInputStream(file);
            boolean endOfFile = false;
            while(!endOfFile){
                try {
                    accounts.add((Account) inputFile.readObject());
                } catch (EOFException e) {
                    endOfFile = true;
                } catch (Exception f){
                    JOptionPane.showMessageDialog(null,"Error at reading file!");
                }
            }
            inputFile.close();
        } catch (IOException e) {
          JOptionPane.showMessageDialog(null,"File don't exist!");
          System.out.println(e.getMessage());
        }
    }

    public void saveAccount(){
        try {
            FileOutputStream file = new FileOutputStream("Registration.txt");
            ObjectOutputStream outputFile = new ObjectOutputStream(file);
            for(int i = 0; i<accounts.size();i++){
                outputFile.writeObject(accounts.get(i));
            }
            outputFile.close();
            JOptionPane.showMessageDialog(null,"Successfully create an account!");
        } catch (IOException e) {
          JOptionPane.showMessageDialog(null,"File don't exist!");
        }
    }


    public int registration(String username, String password, String ConPass, String email, String firstName, String lastName){
        if(password.equals(ConPass)){
            int flag=0;
            for(int i =0;i<accounts.size();i++){
                if(accounts.get(i).getUsername().equals(username) && accounts.get(i).getPassword().equals(password)){
                    JOptionPane.showMessageDialog(null,"Already Registered Account!");
                    flag=1;
                    break;
                }
            }
            if(flag==0)
            {
                Account account = new Account(username, password, email, firstName, lastName);
                accounts.add(account);
                saveAccount();
                return 1;
            }
        }else{
            JOptionPane.showMessageDialog(null,"Incorrect confirm password, pls check again!");
        }
        return 0;
    }

    public int login(String username, String password){
        int flag=0;
        String adUser = "admin";
        String adPass = "admin";
        for(int i =0;i<accounts.size();i++){
            if(username.equals(adUser) && password.equals(adPass)){
                flag=1;
                JOptionPane.showMessageDialog(null, "Login Successful\nWelcome to the Application, Admin.");
                return 1;
            }else if(accounts.get(i).getUsername().equals(username) && accounts.get(i).getPassword().equals(password)){
                flag=1;
                JOptionPane.showMessageDialog(null, "Login Successful\nWelcome to the Application, Customer.");
                saveUserId(i);
                return 2;
            }
        }
        if(flag==0){
            JOptionPane.showMessageDialog(null,"Incorrect Username or Password, pls check again!");
        }
        return 0;  
    }

    public void saveUserId(int id){
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("id.txt", true)); 
            out.write(id+"\n");
            out.close();
        }
        catch (IOException e) {
            JOptionPane.showMessageDialog(null,"File id.txt don't exist!");
        }
    }

    public int readUserId(){
        try {
            File f = new File("id.txt");
            Scanner content = new Scanner(f);
            int data = Integer.parseInt(content.nextLine().trim());
            content.close();
            return data;
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null,"File id.txt don't exist!");
        }
        return -1;
    }

    public void deleteUserId(){
        PrintWriter pw;
        try {
            pw = new PrintWriter("id.txt");
            pw.close();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null,"File id.txt don't exist!");
        }
    }



}
