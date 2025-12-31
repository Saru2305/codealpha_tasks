import java.util.Scanner;

class Student {
    private int totalMarks;
    private double average;
    private char grade;

    
    public void calculateTotal(int[] marks) {
        totalMarks = 0;
        for (int m : marks) {
            totalMarks += m;
        }
    }


    public void calculateAverage(int subjects) {
        average = (double) totalMarks / subjects;
    }

    
    public void calculateGrade() {
        if (average >= 90)
            grade = 'A';
        else if (average >= 80)
            grade = 'B';
        else if (average >= 70)
            grade = 'C';
        else if (average >= 60)
            grade = 'D';
        else
            grade = 'F';
    }

    
    public void displayResult() {
        System.out.println("\n----- Result -----");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + average + "%");
        System.out.println("Grade: " + grade);
    }
}

public class GradeCalculatorOOP {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of subjects: ");
        int n = sc.nextInt();

        int[] marks = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
        }

        Student s = new Student();
        s.calculateTotal(marks);
        s.calculateAverage(n);
        s.calculateGrade();
        s.displayResult();

        sc.close();
    }
}
