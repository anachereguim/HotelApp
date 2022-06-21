package com.pizza.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel2","ana","Anacarolina1");
            System.out.println("Connected");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return connection;
    }
}
