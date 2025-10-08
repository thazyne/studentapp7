import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully!");
    }

    public void listStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }
        students.forEach(System.out::println);
    }

    public void deleteStudentByNim(String nim) {
        boolean removed = students.removeIf(s -> s.getNim().equals(nim));
        if (removed) {
            System.out.println("Student with NIM " + nim + " deleted successfully!");
        } else {
            System.out.println("Student with NIM " + nim + " not found.");
        }
    }
}
