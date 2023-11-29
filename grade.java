import java.util.Scanner;

public class grade {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();

        // Array to store grades
        int[] grades = new int[numStudents];

        // Input grades from the teacher
        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter grade for student " + (i + 1) + ": ");
            grades[i] = scanner.nextInt();
        }

        // Calculate average, highest, and lowest scores
        double average = calculateAverage(grades);
        int highestScore = findHighestScore(grades);
        int lowestScore = findLowestScore(grades);

        // Display results
        System.out.println("\nResults:");
        System.out.println("Average Score: " + average);
        System.out.println("Highest Score: " + highestScore);
        System.out.println("Lowest Score: " + lowestScore);

        scanner.close();
    }

    // Method to calculate the average score
    private static double calculateAverage(int[] grades) {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.length;
    }

    // Method to find the highest score
    private static int findHighestScore(int[] grades) {
        int highest = grades[0];
        for (int grade : grades) {
            if (grade > highest) {
                highest = grade;
            }
        }
        return highest;
    }

    // Method to find the lowest score
    private static int findLowestScore(int[] grades) {
        int lowest = grades[0];
        for (int grade : grades) {
            if (grade < lowest) {
                lowest = grade;
            }
        }
        return lowest;
    }
}
