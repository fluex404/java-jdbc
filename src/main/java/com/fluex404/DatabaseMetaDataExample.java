package com.fluex404;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class DatabaseMetaDataExample {
    public static void main(String... args) {
        try{
            // load driver to connect database
            Class.forName("org.mariadb.jdbc.Driver");
            // Create Connections
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            // Create DatabaseMetaData
            DatabaseMetaData dmd = con.getMetaData();

            System.out.println("Driver Name : "+dmd.getDriverName());
            System.out.println("Driver Version : "+dmd.getDriverVersion());
            System.out.println("Username : "+dmd.getUserName());
            System.out.println("Database Product Name : "+dmd.getDatabaseProductName());
            System.out.println("Database Product Version : "+dmd.getDatabaseProductVersion());

        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
