import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class StudentManagementApp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            StudentService service = new StudentService();

            while (true) {
                System.out.println("\n=== Student Management Menu ===");
                System.out.println("1. Add Student");
                System.out.println("2. List Students");
                System.out.println("3. Delete Student by NIM");
                System.out.println("99. Exit");
                System.out.print("Choose option: ");

                int choice = scanner.nextInt();
                scanner.nextLine();  // Consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter NIM: ");
                        String nim = scanner.nextLine();
                        System.out.print("Enter Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Date of Birth (yyyy-MM-dd): ");
                        String dobStr = scanner.nextLine();
                        LocalDate dob = null;
                        try {
                            dob = LocalDate.parse(dobStr);
                        } catch (DateTimeParseException e) {
                            System.out.println("Invalid date format. Please use yyyy-MM-dd.");
                            break;
                        }
                        System.out.print("Enter Address: ");
                        String address = scanner.nextLine();
                        Student student = new Student();
                        student.setNim(nim);
                        student.setName(name);
                        student.setDob(dob);
                        student.setAddress(address);
                        service.addStudent(student);
                        break;


                    case 2:
                        service.listStudents();
                        break;

                    case 3:
                        System.out.print("Enter NIM to delete: ");
                        String nimToDelete = scanner.nextLine();
                        service.deleteStudentByNim(nimToDelete);
                        break;

                    case 99:
                        System.out.println("Goodbye!");
                        return;

                    default:
                        System.out.println("Invalid option.");
                }
            }
        }
    }
}
