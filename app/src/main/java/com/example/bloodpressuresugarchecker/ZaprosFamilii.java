package com.example.bloodpressuresugarchecker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ZaprosFamilii extends Thread {
    final String url = "jdbc:mysql://zeusiknp.beget.tech:3306/zeusiknp_1";
    final String user = "zeusiknp_1";
    final String password = "381288z";

    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;
    String fio = "deunich";
int id  = 999000;
    public void run( String query, int zapros) {
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

            // executing SELECT query
            rs = stmt.executeQuery(query);

            try {
                {
                    if ( zapros == 1){
                        while (rs.next()) {
                            fio = rs.getString("FIO");

                        }

                    }else{
                        while (rs.next()) {

                            id = rs.getInt("ID");
                        }
                    }



                    }
                }catch (SQLException e){
                e.printStackTrace();
            }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }



        }
        public int getIds(){
        return  id;
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
        try {

            rs.close();

        } catch (SQLException se) { /*can't do anything */ } catch (NullPointerException e) {
        }
    }

    public String getFio() {
        return fio;
    }
}

