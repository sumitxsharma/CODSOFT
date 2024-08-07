import java.util.Scanner;

public class GradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Number of subjects
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        // Array to store marks
        int[] marks = new int[numSubjects];

        // Input: Marks for each subject
        for (int i = 0; i < numSubjects; i++) {
            int mark;
            do {
                System.out.print("Enter marks obtained in subject " + (i + 1) + " (out of 100): ");
                mark = scanner.nextInt();
                
                // Check if the mark is within the valid range
                if (mark < 0 || mark > 100) {
                    System.out.println("Invalid input. Marks must be between 0 and 100. Please try again.");
                }
            } while (mark < 0 || mark > 100);
            
            marks[i] = mark;
        }

        // Calculate Total Marks
        int totalMarks = 0;
        for (int mark : marks) {
            totalMarks += mark;
        }

        // Calculate Average Percentage
        double averagePercentage = (double) totalMarks / numSubjects;

        // Calculate Grade
        String grade;
        if (averagePercentage >= 90) {
            grade = "A+";
        } else if (averagePercentage >= 80) {
            grade = "A";
        } else if (averagePercentage >= 70) {
            grade = "B";
        } else if (averagePercentage >= 60) {
            grade = "C";
        } else if (averagePercentage >= 50) {
            grade = "D";
        } else {
            grade = "F";
        }

        // Display Results
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);

        // Close the scanner
        scanner.close();
    }
}
