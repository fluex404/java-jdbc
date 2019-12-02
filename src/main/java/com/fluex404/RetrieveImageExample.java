package com.fluex404;

import java.io.FileOutputStream;
import java.sql.*;

public class RetrieveImageExample {
    public static void main(String... args) {
        try {
            // load driver to connect database
            Class.forName("org.mariadb.jdbc.Driver");
            // Create Connections
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            // Create PreparedStament, responsible to execute query
            PreparedStatement ps = con.prepareStatement("SELECT * FROM student s WHERE s.id = 8");

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Blob b = rs.getBlob("image");
                byte[] bytes = b.getBytes(1, (int) b.length());
                FileOutputStream fos = new FileOutputStream("/home/fluex404/Pictures/isa-output.jpg");
                fos.write(bytes);
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
