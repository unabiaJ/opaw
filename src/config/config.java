/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.sql.*;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Administrator
 */
public class config {

    /**
     * Opens and returns a SQLite connection to fishsale.db
     */
    public static Connection connectDB() {
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:fishsale.db");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Connection error: " + ex.getMessage());
        }
        return conn;
    }

    /**
     * Executes any INSERT / UPDATE / DELETE with variadic parameters.
     * Usage: addRecord("INSERT INTO tbl_user (...) VALUES (?,?,?)", v1, v2, v3);
     */
    public void addRecord(String sql, Object... params) {
        try (Connection conn = connectDB();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("addRecord error: " + ex.getMessage());
        }
    }

    /**
     * Loads a SELECT query result into a JTable using rs2xml DbUtils.
     * Usage: displayData("SELECT ... FROM ... WHERE col LIKE ?", table, "%kw%");
     */
    public void displayData(String sql, JTable table, Object... params) {
        try (Connection conn = connectDB();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }
            ResultSet rs = ps.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException ex) {
            System.out.println("displayData error: " + ex.getMessage());
        }
    }

    /**
     * Authenticates a user and returns their type ("admin"/"user"), or null if not found.
     */
    public String authenticate(String sql, String username, String password) {
        try (Connection conn = connectDB();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("type");
            }
        } catch (SQLException ex) {
            System.out.println("authenticate error: " + ex.getMessage());
        }
        return null;
    }
}