
package it2c.bacus.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class viewandupdate {
    
     public void updateRecord(String sql, Object... values) {
        try (Connection conn = this.connectDB(); 
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

       
            for (int i = 0; i < values.length; i++) {
                if (values[i] instanceof Integer) {
                    pstmt.setInt(i + 1, (Integer) values[i]); 
                } else if (values[i] instanceof Double) {
                    pstmt.setDouble(i + 1, (Double) values[i]); 
                } else if (values[i] instanceof Float) {
                    pstmt.setFloat(i + 1, (Float) values[i]); 
                } else if (values[i] instanceof Long) {
                    pstmt.setLong(i + 1, (Long) values[i]); 
                } else if (values[i] instanceof Boolean) {
                    pstmt.setBoolean(i + 1, (Boolean) values[i]); 
                } else if (values[i] instanceof java.util.Date) {
                    pstmt.setDate(i + 1, new java.sql.Date(((java.util.Date) values[i]).getTime()));
                } else if (values[i] instanceof java.sql.Date) {
                    pstmt.setDate(i + 1, (java.sql.Date) values[i]);
                } else if (values[i] instanceof java.sql.Timestamp) {
                    pstmt.setTimestamp(i + 1, (java.sql.Timestamp) values[i]);
                } else {
                    pstmt.setString(i + 1, values[i].toString()); 
                }
            }

            pstmt.executeUpdate();
            System.out.println("Record updated successfully!");
        } catch (SQLException e) {
            System.out.println("Error updating record: " + e.getMessage());
        }
     }
}
