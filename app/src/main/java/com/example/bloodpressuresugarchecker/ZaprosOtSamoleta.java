package com.example.bloodpressuresugarchecker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ZaprosOtSamoleta extends Thread {
    final String url = "jdbc:mysql://zeusiknp.beget.tech:3306/zeusiknp_1";
    final String user = "zeusiknp_1";
    final String password = "381288z";

    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    public void run(String date1,String destination,int[] mass, String query) {
        try {
            Class.forName("com.mysql.jdbc.Driver");//подключили драйвер
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

                    while (rs.next()) {// в этом блоке делаем то что нам нужно от результата

                        for (int i = 0; i <mass.length ; i++) {
                           mass[i] = rs.getInt("M"+(i+1));

                        }



                    }

            } catch (SQLException e1) {
                e1.printStackTrace();
            }



        }catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }


    }

    public void closer(){// закрываем соединение
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

}

