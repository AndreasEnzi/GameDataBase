package com.company;

import java.sql.*;

public class GameDataBase {

    Connection conn = null;


    GameDataBase(){
        connecttoSQLiteDb();
        addNewConsole("X-Box 360", "microsoft", "2005-11-22");

        //addNewGame("Crash Bandicoot 1", "Platformer", "ps1");
    }
    public void addNewConsole(String name, String company , String  start_date){

        try{
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO console(name,company, start_date)VALUES(?,?, ?)");
            stmt.setString(1, name);
            stmt.setString(2 ,company);
            stmt.setString(3, start_date);


            //executeUpdate is for changing the data in the database
            stmt.executeUpdate();

            //we can get the auto incremented ids from the stmt after update is run

        }catch(Exception e){

            e.printStackTrace();
        }

    }
    public void addOldConsole(String name){//idk man


    }
    public String Xbox360( String name){//idk man
         name = "X-box 360";

        return name;
    }
    public void addNewGame(String name, String genre , String  console){

        try{
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Game(name,genre, console)VALUES(?,?, ?)");
            stmt.setString(1, name);
            stmt.setString(2 ,genre);
            stmt.setString(3, console);


            //executeUpdate is for changing the data in the database
            stmt.executeUpdate();

            //we can get the auto incremented ids from the stmt after update is run

        }catch(Exception e){

            e.printStackTrace();
        }

    }

    void connecttoSQLiteDb(){

        try {
            conn = DriverManager.getConnection("jdbc:sqlite:GameDataBase.db");
        } catch (Exception ex) { ex.printStackTrace();
        }
    }
}
