package com.fluex404;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class StoreImageExample {
    public static void main(String... args) {
        try {
            // load driver to connect database
            Class.forName("org.mariadb.jdbc.Driver");
            // Create Connections
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            // Create PreparedStament, responsible to execute query
            PreparedStatement ps = con.prepareStatement("INSERT INTO student (name, email, image) values(?, ?, ?)");

            ps.setString(1, "Goni");
            ps.setString(2, "goni@gmail.com");

            FileInputStream fis = new FileInputStream("/home/fluex404/Pictures/isa.jpg");
            ps.setBinaryStream(3, fis, fis.available());
            ps.execute();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
