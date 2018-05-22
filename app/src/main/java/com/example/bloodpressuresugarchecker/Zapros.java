package com.example.bloodpressuresugarchecker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Zapros extends Thread {
    final String url = "jdbc:mysql://zeusiknp.beget.tech:3306/zeusiknp_1";
    final String user = "zeusiknp_1";
    final String password = "381288z";
    ArrayList<String> cities = new ArrayList<String>();
    ArrayList<Integer> ids = new ArrayList<Integer>();
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;
    public void run(String date1) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String query ="select ID,RaceName from Race where date=\""+date1+"\"" ;


        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);// подключение

            // getting Statement object to execute query
            stmt = con.createStatement();

            // executing SELECT query
            rs = stmt.executeQuery(query);

            try {
                while (rs.next()) {
                    String  count = rs.getString("RaceName");
                   int id = rs.getInt("ID");
                    if(count!= null)
                    {
                        cities.add(count);
                        ids.add(id);
                    }



                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }

        for (int j = 0; j < cities.size(); j++) {
            System.out.println(cities.get(j));
        }
    }
public ArrayList<String> returner(){
        return cities;
    }
    public ArrayList<Integer> retid(){
        return ids;
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
}

