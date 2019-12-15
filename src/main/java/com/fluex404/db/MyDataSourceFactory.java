package com.fluex404.db;

import org.mariadb.jdbc.MySQLDataSource;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.util.Properties;

public class MyDataSourceFactory {
    public static DataSource getMariaDBDataSource(){
        Properties props = new Properties();
        FileInputStream fis = null;
        MySQLDataSource mysqlDB = null;
        try{
            fis = new FileInputStream("db.properties");
            props.load(fis);
            mysqlDB = new MySQLDataSource();
            mysqlDB.setUrl(props.getProperty("MARIADB_URL"));
            mysqlDB.setUser(props.getProperty("MARIADB_USERNAME"));
            mysqlDB.setUser(props.getProperty("MARIADB_PASSWORD"));
        }catch(Exception e) {
            e.printStackTrace();
        }
        return mysqlDB;
    }
}
