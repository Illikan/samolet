package com.example.bloodpressuresugarchecker;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class zaprosdannixpobiletu extends Thread {
    final String url = "jdbc:mysql://zeusiknp.beget.tech:3306/zeusiknp_1";
    final String user = "zeusiknp_1";
    final String password = "381288z";

    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;
    int id = 0;
String fio = "";
    String racename = "";
    int place = 0;
     String date = "";


    public void run(int number) {
        try {
            Class.forName("com.mysql.jdbc.Driver");//подключили драйвер
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

String query = "select * from Ticket where Number =\"" + number +"\"";


        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);// подключение

            // getting Statement object to execute query
            stmt = con.createStatement();

            // executing SELECT query
            rs = stmt.executeQuery(query);

            try {
                {
                    while (rs.next()) {
                   fio = rs.getString("FIO");
                        System.out.println(fio);
                   place = rs.getInt("Place");
                id = rs.getInt("RaceID");




                    }
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }



        }catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
       closer();
        String queryk = "select * from Race where ID =\"" + id +"\"";

        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);// подключение

            // getting Statement object to execute query
            stmt = con.createStatement();

            // executing SELECT query
            rs = stmt.executeQuery(queryk);

            try {
                {
                    while (rs.next()) {
                        date = rs.getString("Date");
                        System.out.println(date);
                        racename = rs.getString("RaceName");





                    }
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }



        }catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
    }
    public String getFio() {
        return fio;
    }

    public int getPlace() {
        return place;
    }
    public String getDate() {
        return date;
    }

    public String getRacename() {
        return racename;
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
