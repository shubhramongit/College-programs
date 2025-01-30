package java_programs;

import java.util.Scanner;

public class Question_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.println("Enter the length of the array: ");
        int n = scanner.nextInt();
        int[] array = new int[n];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        
        System.out.println("Enter the number of positions to shift: ");
        int k = scanner.nextInt();
        System.out.println("Enter shift direction (L for left, R for right): ");
        char direction = scanner.next().charAt(0);

        scanner.close();

        k = k % n; 

        if (direction == 'L' || direction == 'l') {
            shiftLeft(array, k);
        } else if (direction == 'R' || direction == 'r') {
            shiftRight(array, k);
        } else {
            System.out.println("Invalid direction input!");
            return;
        }

        System.out.println("Array after shifting: ");
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    public static void shiftLeft(int[] array, int k) {
        int n = array.length;
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            temp[i] = array[(i + k) % n];
        }
        System.arraycopy(temp, 0, array, 0, n);
    }

    public static void shiftRight(int[] array, int k) {
        int n = array.length;
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            temp[(i + k) % n] = array[i];
        }
        System.arraycopy(temp, 0, array, 0, n);
    }
}

