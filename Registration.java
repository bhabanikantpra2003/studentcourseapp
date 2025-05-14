
import java.sql.*;
import java.util.Scanner;

public class Registration {
    public static void register(Scanner scanner) throws SQLException {
        System.out.print("Enter your student email: ");
        String email = scanner.nextLine();

        Connection conn = DBConnection.connect();

        PreparedStatement findStudent = conn.prepareStatement("SELECT id FROM students WHERE email = ?");
        findStudent.setString(1, email);
        ResultSet rs = findStudent.executeQuery();

        if (!rs.next()) {
            System.out.println("Student not found.");
            return;
        }

        int studentId = rs.getInt("id");
        Course.viewCourses();

        System.out.print("Enter course ID to register: ");
        int courseId = Integer.parseInt(scanner.nextLine());

        PreparedStatement stmt = conn.prepareStatement("INSERT INTO registrations (student_id, course_id) VALUES (?, ?)");
        stmt.setInt(1, studentId);
        stmt.setInt(2, courseId);
        stmt.executeUpdate();

        System.out.println("Registration successful!");
        conn.close();
    }
}
