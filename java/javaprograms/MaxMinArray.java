//Write a JAVA program to convert array to maximum minimum array (Input: 1 2 3 4 5,
//Output: 5 1 4 2 3). Do for both sorted and unsorted array.


import java.util.Arrays;

public class MaxMinArray {
    // Function to reorder the array in the required max-min way
    public static void reorder(int arr[]) {
        Arrays.sort(arr); // Sort the array (for unsorted input)

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

    // Function to handle both sorted and unsorted input
    public static void maxMinArray(int arr[]) {
        // Check if the array is sorted
        boolean isSorted = true;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                isSorted = false;
                break;
            }
        }

        // If the array is already sorted, directly reorder it
        if (isSorted) {
            reorder(arr);
        } else {
            // If the array is unsorted, sort it and then reorder
            Arrays.sort(arr);
            reorder(arr);
        }
    }

    public static void main(String[] args) {
        // Test with an unsorted array
        int arr[] = {3, 1, 4, 2, 5};
        System.out.println("Original Array: " + Arrays.toString(arr));
        
        maxMinArray(arr);
        
        System.out.println("Reordered Array: " + Arrays.toString(arr));

        // Test with a sorted array
        int sortedArr[] = {1, 2, 3, 4, 5};
        System.out.println("Original Sorted Array: " + Arrays.toString(sortedArr));
        
        maxMinArray(sortedArr);
        
        System.out.println("Reordered Sorted Array: " + Arrays.toString(sortedArr));
    }
}
