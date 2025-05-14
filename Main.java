
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== Student Course Registration ===");
            System.out.println("1. Add Student");
            System.out.println("2. View Courses");
            System.out.println("3. Register for a Course");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            
            int choice = Integer.parseInt(scanner.nextLine());

            try {
                switch (choice) {
                    case 1 -> Student.addStudent(scanner);
                    case 2 -> Course.viewCourses();
                    case 3 -> Registration.register(scanner);
                    case 4 -> {
                        System.out.println("Exiting...");
                        return;
                    }
                    default -> System.out.println("Invalid choice.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
