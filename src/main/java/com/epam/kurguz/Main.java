package com.epam.kurguz;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) {
       Connection connection = DriverManager.getConnection();
    }
}
