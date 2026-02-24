package config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import net.proteanit.sql.DbUtils;
/**
 *
 * @author HP Pro C640
 */
public class config {
    public static Connection connectDB() {
        Connection con = null;
        try {
            Class.forName("org.sqlite.JDBC"); // Load the SQLite JDBC driver
            con = DriverManager.getConnection("jdbc:sqlite:fishsale.db"); // Establish connection
            System.out.println("Connection Successful");
        } catch (Exception e) {
            System.out.println("Connection Failed: " + e);
        }
        return con;
    }
    
    public void addRecord(String sql, Object... values) {
    try (Connection conn = connectDB();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        for (int i = 0; i < values.length; i++) {
            pstmt.setObject(i + 1, values[i]);
        }
        pstmt.executeUpdate();
        System.out.println("Record added successfully!");
    } catch (SQLException e) {
        System.out.println("Error adding record: " + e.getMessage());
    }
}
    
    public String authenticate(String sql, Object... values) {
    try (Connection conn = connectDB();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        for (int i = 0; i < values.length; i++) {
            pstmt.setObject(i + 1, values[i]);
        }
        try (ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                return rs.getString("type");
            }
        }
    } catch (SQLException e) {
        System.out.println("Login Error: " + e.getMessage());
    }
    return null;
}
    
    public void displayData(String sql, javax.swing.JTable table, Object... values) {
    try (Connection conn = connectDB();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        
        // Set the parameters for the search
        for (int i = 0; i < values.length; i++) {
            pstmt.setObject(i + 1, values[i]);
        }
        try (ResultSet rs = pstmt.executeQuery()) {
            // Automatically maps the filtered ResultSet to your JTable
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        
    } catch (SQLException e) {
        System.out.println("Error filtering data: " + e.getMessage());
    }
}
    
}
