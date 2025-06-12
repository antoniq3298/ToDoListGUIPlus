package database;

import model1.JavaTask;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBManager {
    private static final String URL = "jdbc:sqlite:tasks.db";

    public DBManager() {
        try (Connection conn = DriverManager.getConnection(URL)) {
            Statement stmt = conn.createStatement();
            stmt.execute(
                    "CREATE TABLE IF NOT EXISTS tasks (" +
                            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                            "title TEXT NOT NULL, " +
                            "status TEXT DEFAULT 'Pending', " +
                            "priority TEXT DEFAULT 'Medium'" +
                            ")"
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void addTask(String title, String status, String priority) {
        String sql = "INSERT INTO tasks(title, status, priority) VALUES(?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, title);
            pstmt.setString(2, status);
            pstmt.setString(3, priority);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<JavaTask> getAllTasks() {
        List<JavaTask> tasks = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM tasks")) {
            while (rs.next()) {
                tasks.add(new JavaTask(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("status"),
                        rs.getString("priority")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tasks;
    }
}
