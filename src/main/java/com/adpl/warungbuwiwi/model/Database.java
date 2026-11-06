package com.adpl.warungbuwiwi.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String URL = "jdbc:mysql://localhost:3306/db_warung";
    private static final String USER = "root"; 
    private static final String PASS = "142400";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }

    public static void main(String[] args) {
        try (Connection conn = getConnection()) {
            if (conn != null) {
                System.out.println("Status: Berhasil terhubung ke database db_warung!");
            }
        } catch (SQLException e) {
            System.err.println("Status: Gagal terhubung!");
            System.err.println("Pesan Error: " + e.getMessage());
        }
    }
}