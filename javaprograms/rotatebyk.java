import java.util.*;

public class rotatebyk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no. of elements in an array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the elements of an array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int arr1[] = new int[n]; // Corrected declaration
        System.out.println("Enter the number of positions to rotate: ");
        int k = sc.nextInt();
        if (k > arr.length) {
            k = k % arr.length;
        }
        int j = 0;
        for (int i = k; i < arr.length; i++) {
            arr1[j] = arr[i];
            j++;
        }
        for (int i = 0; i < k; i++) {
            arr1[j] = arr[i];
            j++;
        }

        System.out.println("Original array");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        
        System.out.println("Rotated array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.println(); // Added to ensure output appears correctly
    }
}
