package com.parking.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.io.InputStream;

public class DBConnection {

    public static Connection getConnection() {
        try {
            Properties props = new Properties();
            InputStream is = DBConnection.class
                    .getClassLoader()
                    .getResourceAsStream("db.properties");
            props.load(is);

            Class.forName(props.getProperty("driver"));

            return DriverManager.getConnection(
                    props.getProperty("url"),
                    props.getProperty("username"),
                    props.getProperty("password")
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
