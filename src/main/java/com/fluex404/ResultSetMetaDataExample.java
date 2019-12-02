package com.fluex404;

import java.sql.*;

public class ResultSetMetaDataExample {
    public static void main(String... args) {
        try {
            // load driver to connect database
            Class.forName("org.mariadb.jdbc.Driver");
            // Create Connections
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            // Prepared Statement, resposible to execute query
            PreparedStatement ps = con.prepareStatement("SELECT * FROM student");
            // ResultSet from PrepareStatement
            ResultSet rs = ps.executeQuery();

            // ResultSetMetadata get from ResultSet
            ResultSetMetaData rsm = rs.getMetaData();


            System.out.println("Total Column : "+rsm.getColumnCount());
            System.out.println("Column name of 4 index : "+rsm.getColumnName(4));
            System.out.println("Column Type of 5 index : "+rsm.getColumnTypeName(5));

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
