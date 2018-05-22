package com.example.bloodpressuresugarchecker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class updating extends Thread {
    final String url = "jdbc:mysql://zeusiknp.beget.tech:3306/zeusiknp_1";
    final String user = "zeusiknp_1";
    final String password = "381288z";

    private static Connection con;
    private static Statement stmt;


    public void run( String query) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }



        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);// подключение

            // getting Statement object to execute query
            stmt = con.createStatement();
            stmt.executeUpdate(query);








        } catch (SQLException e1) {
            e1.printStackTrace();
        }



    }




    public void closer(){
        try {

            con.close();

        } catch (SQLException se) { /*can't do anything */ } catch (NullPointerException e) {
            e.printStackTrace();

        }
        try {

            stmt.close();
        } catch (SQLException se) { /*can't do anything */ } catch (NullPointerException e) {
        }

    }

}