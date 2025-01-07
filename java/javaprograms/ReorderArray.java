//Given an unsorted array, write a JAVA program reorder the elements of the array to store the numbers as maximum, minimum, second maximum, second minimum, third maximum, third minimum, and so on. (I/p: 1 2 3 4 5, O/p: 5 1 4 2 3)

import java.util.Arrays;

public class ReorderArray {
    // Function to reorder the array
    public static void reorder(int arr[]) {
        Arrays.sort(arr); // Sort the array
        int[] temp = new int[arr.length];
        int start = 0, end = arr.length - 1;
        
        // Reorder the array in the required way
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                temp[i] = arr[end--];
            } else {
                temp[i] = arr[start++];
            }
        }
        
        // Copy the temp array to the original array
        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp[i];
        }
    }

    // Main function
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        System.out.println("Original Array: " + Arrays.toString(arr));
        
        reorder(arr);
        
        System.out.println("Reordered Array: " + Arrays.toString(arr));
    }
}
