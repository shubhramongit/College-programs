
import java.util.Scanner;

public class Arrayreduction {
    
    // Function to reduce the array
    public static void reduceArray(int[] arr) {
        int count = 0;
        while (true) {
            // Find the smallest non-zero element
            int min = findSmallestNonZeroElement(arr);
            if (min == 0)
                break; // All elements are zero

            // Subtract the smallest non-zero element from all non-zero elements
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > 0)
                    arr[i] -= min;
            }

            // Print the array after each reduction
            for (int value : arr) {
                System.out.print(value + " ");
            }
            System.out.println();
            count++;
        }
        System.out.println("Number of Reduction steps = " + count);
    }

    // Function to find the smallest non-zero element
    public static int findSmallestNonZeroElement(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int value : arr) {
            if (value > 0 && value < min)
                min = value;
        }
        return (min == Integer.MAX_VALUE) ? 0 : min;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: size of the array
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();

        // Handle edge case
        if (n <= 0) {
            System.out.println("Array should have at least one element.");
            sc.close();
            return;
        }

        // Input: elements of the array
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Close the scanner
        sc.close();

        // Perform array reduction
        reduceArray(arr);
    }
}
