package com.example.bloodpressuresugarchecker;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class OtpravkaDataTicket extends Thread {




        final String url = "jdbc:mysql://zeusiknp.beget.tech:3306/zeusiknp_1";
        final String user = "zeusiknp_1";
        final String password = "381288z";

        private static Connection con;
        private static Statement stmt1;
    private static Statement stmt2;
        private static ResultSet rs;
int ids = 99900;
        public void run(String query1,String query2, String fio, int id, int place) {
            try {
                Class.forName("com.mysql.jdbc.Driver");//подключили драйвер
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


            try {
                // opening database connection to MySQL server
                con = DriverManager.getConnection(url, user, password);// подключение

                // getting Statement object to execute query
                stmt1 = con.createStatement();

                stmt1.executeUpdate(query1);

                stmt2 = con.createStatement();

                rs = stmt2.executeQuery(query2);
                try {

                    while (rs.next()) {// в этом блоке делаем то что нам нужно от результата

                        ids = rs.getInt("ID");

                    }

                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            } catch (SQLException e) {


                // executing SELECT query


            }
        }
  public int getIds(){
            return ids;
}
        public void closer(){// закрываем соединение
            try {

                con.close();

            } catch (SQLException se) { /*can't do anything */ } catch (NullPointerException e) {
                e.printStackTrace();

            }
            try {

                stmt1.close();
            } catch (SQLException se) { /*can't do anything */ } catch (NullPointerException e) {
            }
            try {

                stmt2.close();
            } catch (SQLException se) { /*can't do anything */ } catch (NullPointerException e) {
            }
            try {

                rs.close();
            } catch (SQLException se) { /*can't do anything */ } catch (NullPointerException e) {
            }
        }

    }



