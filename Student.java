
import java.sql.*;
import java.util.Scanner;

public class Student {
    public static void addStudent(Scanner scanner) throws SQLException {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        Connection conn = DBConnection.connect();
        String sql = "INSERT INTO students (name, email) VALUES (?, ?)";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, name);
        stmt.setString(2, email);

        stmt.executeUpdate();
        System.out.println("Student added!");
        conn.close();
    }
}
