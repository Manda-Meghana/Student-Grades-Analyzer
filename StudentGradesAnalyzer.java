import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradesAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        ArrayList<String> studentNames = new ArrayList<>();
        ArrayList<double[]> studentGrades = new ArrayList<>();
        
        // Input student names and grades
        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter student name: ");
            String name = scanner.nextLine();
            studentNames.add(name);

            System.out.println("Enter grades for " + name + ": ");
            double[] grades = new double[5]; // Assuming 5 subjects
            for (int j = 0; j < 5; j++) {
                System.out.print("Subject " + (j + 1) + ": ");
                grades[j] = scanner.nextDouble();
            }
            scanner.nextLine(); // Consume newline
            studentGrades.add(grades);
        }

        // Compute average, highest, lowest scores, and percentage for each student
        double highestAverage = Double.MIN_VALUE;
        double lowestAverage = Double.MAX_VALUE;
        String classTopper = "";
        int classTopperIndex = -1;
        
        for (int i = 0; i < numStudents; i++) {
            double[] grades = studentGrades.get(i);
            double total = 0;
            double highest = Double.MIN_VALUE;
            double lowest = Double.MAX_VALUE;
            
            for (double grade : grades) {
                total += grade;
                if (grade > highest) highest = grade;
                if (grade < lowest) lowest = grade;
            }

            double average = total / grades.length;
            double percentage = (total / (grades.length * 100)) * 100;
            
            System.out.println("\nStudent: " + studentNames.get(i));
            System.out.println("Average: " + average);
            System.out.println("Highest Score: " + highest);
            System.out.println("Lowest Score: " + lowest);
            System.out.println("Percentage: " + percentage + "%");

            // Update class topper
            if (average > highestAverage) {
                highestAverage = average;
                classTopper = studentNames.get(i);
                classTopperIndex = i;
            }
            
            // Update lowest average
            if (average < lowestAverage) {
                lowestAverage = average;
            }
        }

        // Display class topper
        System.out.println("Class Topper: " + classTopper + " with an average of " + highestAverage);

        scanner.close();
    }
}
