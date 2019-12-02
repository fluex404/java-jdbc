package com.fluex404;

import java.sql.*;

public class StatementExample {
    public static void main(String... args) {
        try {
            Class.forName("org.mariadb.jdbc.Driver");

            // Create Connections
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");

            // Create Statement, responsible to execute query
            Statement st = con.createStatement();
            // Resultset, result of query is ResultSet
            ResultSet rs = st.executeQuery("SELECT s.id, s.name, s.email, s.age *2 AS age FROM student s");

            // get the data, with index of column
            System.out.println("Next");
            while(rs.next()) {
                System.out.println("Id : "+rs.getLong(1));
                System.out.println("Name : "+rs.getString(2));
                System.out.println("Email : "+rs.getString(3));
                System.out.println("Age : "+rs.getInt(4));
                System.out.println("======================");
            }
            System.out.println("First");
//            while(rs.first()) {
//                System.out.println("Id : "+rs.getLong(1));
//                System.out.println("Name : "+rs.getString(2));
//                System.out.println("Email : "+rs.getString(3));
//                System.out.println("Age : "+rs.getInt(4));
//                System.out.println("======================");
//            }
            System.out.println("Previous");
            while(rs.previous()) {
                System.out.println("Id : "+rs.getLong(1));
                System.out.println("Name : "+rs.getString(2));
                System.out.println("Email : "+rs.getString(3));
                System.out.println("Age : "+rs.getInt(4));
                System.out.println("======================");
            }

            System.out.println("Absolute");
            if(rs.absolute(2)){
                System.out.println("Id : "+rs.getLong(1));
                System.out.println("Name : "+rs.getString(2));
                System.out.println("Email : "+rs.getString(3));
                System.out.println("Age : "+rs.getInt(4));
                System.out.println("======================");
            }



            // close the connection
            con.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
