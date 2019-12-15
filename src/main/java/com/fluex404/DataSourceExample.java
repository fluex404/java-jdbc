package com.fluex404;

import com.fluex404.db.MyDataSourceFactory;
import org.mariadb.jdbc.MySQLDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataSourceExample {
    public static void main(String[] args) {
        DataSource ds = MyDataSourceFactory.getMariaDBDataSource();
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        try{
            con = ds.getConnection();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT * FROM book");

            while(rs.next()) {
                System.out.println(rs.getLong(1));
                System.out.println(rs.getString(2));
                System.out.println(rs.getString(3));
                System.out.println(rs.getDate(4));
                System.out.println("--------------------");
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
