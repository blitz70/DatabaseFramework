package com.iamtek.hibernate;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

    public static void main(String[] args) {

        String jdbcUrl = "jdbc:postgresql://localhost:5432/mydb";
        String username = "postgres";
        String password = "postgresql";

        try {
            System.out.println("Connecting to db: " + jdbcUrl);
            Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Connection success!");
        } catch (Exception e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
    }
}
