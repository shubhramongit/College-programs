import java.util.Scanner;

public class sumarrayn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask user for the number of elements in the array
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        // Declare the array
        int[] numbers = new int[n];

        // Read the elements into the array
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++)
         {
            numbers[i] = scanner.nextInt();
        }

        // Calculate the sum of the array elements
        int sum = 0;
        for (int number : numbers)
         {
            sum += number;
        }

        // Display the sum
        System.out.println("The sum of the array elements is: " + sum);
    }
}
