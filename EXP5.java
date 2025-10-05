import java.util.ArrayList;
import java.util.Scanner;

public class SumOfIntegers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create a list to store Integer objects
        ArrayList<Integer> numbers = new ArrayList<>();

        // Accept multiple integers as a single line input
        System.out.println("Enter integers separated by spaces:");
        String inputLine = sc.nextLine();

        // Split the input into individual string numbers
        String[] inputStrings = inputLine.split("\\s+");

        // Convert each string to Integer using parsing
        for (String str : inputStrings) {
            try {
                int num = Integer.parseInt(str); // Parse string to primitive int
                numbers.add(num);                // Autoboxing: int -> Integer
            } catch (NumberFormatException e) {
                System.out.println("Invalid input skipped: " + str);
            }
        }

        // Calculate the sum using enhanced for-loop with unboxing
        int sum = 0;
        for (Integer numObj : numbers) {
            sum += numObj; // Unboxing: Integer -> int
        }

        // Display the total sum
        System.out.println("The total sum is: " + sum);

        sc.close();
    }
}
