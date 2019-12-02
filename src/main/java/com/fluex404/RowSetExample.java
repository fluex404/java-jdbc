package com.fluex404;

import com.sun.rowset.JdbcRowSetImpl;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class RowSetExample {
    public static void main(String... args) {
        try {
            // load driver to connect database
            Class.forName("org.mariadb.jdbc.Driver");

            // create and executing RowSet
            JdbcRowSet jrs = RowSetProvider.newFactory().createJdbcRowSet();
            jrs.setUrl("jdbc:mysql://localhost:3306/test");
            jrs.setUsername("root");
            jrs.setPassword("");


            jrs.setCommand("SELECT s.id, s.name, s.email, s.age *2 AS age FROM student s");
            jrs.execute();
            while(jrs.next()) {
                System.out.println("Id : "+jrs.getLong(1));
                System.out.println("Name : "+jrs.getString(2));
                System.out.println("Email : "+jrs.getString(3));
                System.out.println("Age : "+jrs.getInt(4));
                System.out.println("======================");
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
