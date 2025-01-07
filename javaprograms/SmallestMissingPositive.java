//Given an unsorted array with both positive and negative elements, write a JAVA program to find the smallest positive number missing from the array.


import java.util.Arrays;

public class SmallestMissingPositive {
    // Function to segregate positive and negative numbers
    static int segregate(int arr[], int size) {
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (arr[i] <= 0) {
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++; // Increment count of negative numbers
            }
        }
        return j;
    }

    // Find the smallest positive number missing from the array
    static int findMissingPositive(int arr[], int size) {
        // Traverse the array and mark the presence of elements
        for (int i = 0; i < size; i++) {
            int x = Math.abs(arr[i]);
            if (x - 1 < size && arr[x - 1] > 0) {
                arr[x - 1] = -arr[x - 1];
            }
        }
        // Identify the missing number
        for (int i = 0; i < size; i++) {
            if (arr[i] > 0) {
                return i + 1; // 1 is added to the index to get the actual missing number
            }
        }
        return size + 1;
    }

    // Main function to find the smallest positive number missing from the array
    static int findMissing(int arr[], int size) {
        // First separate positive and negative numbers
        int shift = segregate(arr, size);
        // Use the remaining positive numbers to find the smallest missing positive number
        return findMissingPositive(Arrays.copyOfRange(arr, shift, size), size - shift);
    }

    public static void main(String[] args) {
        int arr[] = {3, 4, -1, 1, -2, 2};
        int size = arr.length;
        int missing = findMissing(arr, size);
        System.out.println("The smallest positive number missing from the array is: " + missing);
    }
}
