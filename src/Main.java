import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] dataPoints = new int[100];
        Random rand = new Random();
        Scanner in = new Scanner(System.in);

        // Loop 1: fill with random values from 1 to 100
        for (int i = 0; i < dataPoints.length; i++) {
            dataPoints[i] = rand.nextInt(100) + 1;
        }

        // Loop 2: display all values on one line
        System.out.println("The values in the random array dataPoints are:");
        for (int i = 0; i < dataPoints.length; i++) {
            System.out.print(dataPoints[i] + " | ");
        }
        System.out.println();

        // Loop 3: calculate the sum and average
        int sum = 0;
        for (int i = 0; i < dataPoints.length; i++) {
            sum += dataPoints[i];
        }
        double average = (double) sum / dataPoints.length;

        System.out.println("The sum of the values in the random array dataPoints is: " + sum);
        System.out.println("The average of the values in the random array dataPoints is: " + average);

        // Prompt for a value between 1 and 100
        int userValue = 0;
        boolean valid = false;
        do {
            System.out.print("Please enter an integer value between 1 and 100: ");
            if (in.hasNextInt()) {
                userValue = in.nextInt();
                if (userValue >= 1 && userValue <= 100) {
                    valid = true;
                } else {
                    System.out.println("That number is out of range. It must be between 1 and 100.");
                }
            } else {
                System.out.println("That is not a valid integer. Please try again.");
            }
            in.nextLine();
        } while (!valid);

        System.out.println("The value you entered is: " + userValue);

        // Loop 4: count how many times the user's value appears in the array
        int count = 0;
        for (int i = 0; i < dataPoints.length; i++) {
            if (dataPoints[i] == userValue) {
                count++;
            }
        }

        if (count == 0) {
            System.out.println("The value " + userValue + " was not found in the random array dataPoints.");
        } else if (count == 1) {
            System.out.println("The value " + userValue + " was found 1 time in the random array dataPoints.");
        } else {
            System.out.println("The value " + userValue + " was found " + count + " times in the random array dataPoints.");
        }

        // Prompt a second time for a value between 1 and 100
        int searchValue = 0;
        valid = false;
        do {
            System.out.print("Please enter another integer value between 1 and 100: ");
            if (in.hasNextInt()) {
                searchValue = in.nextInt();
                if (searchValue >= 1 && searchValue <= 100) {
                    valid = true;
                } else {
                    System.out.println("That number is out of range. It must be between 1 and 100.");
                }
            } else {
                System.out.println("That is not a valid integer. Please try again.");
            }
            in.nextLine();
        } while (!valid);

        System.out.println("The value you entered for the second search is: " + searchValue);

        // Loop 5: find the first position of the value
        boolean found = false;
        int position = -1;
        for (int i = 0; i < dataPoints.length; i++) {
            if (dataPoints[i] == searchValue) {
                found = true;
                position = i;
                break;
            }
        }

        if (found) {
            System.out.println("The value " + searchValue + " was found at array index " + position + ".");
        } else {
            System.out.println("The value " + searchValue + " was not found in the random array dataPoints.");
        }

        // Loop 6: find the minimum and maximum values in a single pass
        int min = dataPoints[0];
        int max = dataPoints[0];
        for (int i = 1; i < dataPoints.length; i++) {
            if (dataPoints[i] < min) {
                min = dataPoints[i];
            }
            if (dataPoints[i] > max) {
                max = dataPoints[i];
            }
        }

        System.out.println("The minimum value in the random array dataPoints is: " + min);
        System.out.println("The maximum value in the random array dataPoints is: " + max);

        // Test getAverage: it takes a double[], so copy the int values into one first
        double[] dataPointsAsDouble = new double[dataPoints.length];
        for (int i = 0; i < dataPoints.length; i++) {
            dataPointsAsDouble[i] = dataPoints[i];
        }

        System.out.println("Average of dataPoints is: " + getAverage(dataPointsAsDouble));
    }

    public static double getAverage(double values[])
    {
        double total = 0;
        for (int i = 0; i < values.length; i++) {
            total += values[i];
        }
        return total / values.length;
    }
}