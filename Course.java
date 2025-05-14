
import java.sql.*;

public class Course {
    public static void viewCourses() throws SQLException {
        Connection conn = DBConnection.connect();
        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT * FROM courses");

        System.out.println("\nAvailable Courses:");
        while (rs.next()) {
            System.out.println(rs.getInt("id") + " - " +
                               rs.getString("name") + " by " +
                               rs.getString("instructor"));
        }
        conn.close();
    }
}
