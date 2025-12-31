import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int rollNo;
    String name;
    String grade;
    String department;

    Student(int rollNo, String name, String grade, String department) {
        this.rollNo = rollNo;
        this.name = name;
        this.grade = grade;
        this.department = department;
    }

    void display() {
        System.out.println("Roll No: " + rollNo +
                ", Name: " + name +
                ", Grade: " + grade +
                ", Department: " + department);
    }
}

public class StudentManagementSystem {

    static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Roll No: ");
                    int roll = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Grade: ");
                    String grade = sc.nextLine();

                    System.out.print("Enter Department: ");
                    String dept = sc.nextLine();

                    students.add(new Student(roll, name, grade, dept));
                    System.out.println("Student added successfully!");
                    break;

                case 2:
                    System.out.print("Enter Roll No to remove: ");
                    int r = sc.nextInt();
                    students.removeIf(s -> s.rollNo == r);
                    System.out.println("Student removed (if existed).");
                    break;

                case 3:
                    System.out.print("Enter Roll No to search: ");
                    int sr = sc.nextInt();
                    boolean found = false;
                    for (Student s : students) {
                        if (s.rollNo == sr) {
                            s.display();
                            found = true;
                        }
                    }
                    if (!found) System.out.println("Student not found!");
                    break;

                case 4:
                    if (students.isEmpty()) {
                        System.out.println("No students available.");
                    } else {
                        for (Student s : students) {
                            s.display();
                        }
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);

        sc.close();
    }
}

    

