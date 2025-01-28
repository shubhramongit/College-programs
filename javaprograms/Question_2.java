package java_programs;
import java.util.Scanner;

public class Question_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        String input = scanner.nextLine();
        scanner.close();

        int[] digitFrequency = new int[10]; 

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isDigit(c)) {
                digitFrequency[c - '0']++;
            }
        }

        System.out.println("Digit frequencies:");
        for (int i = 0; i < digitFrequency.length; i++) {
            if (digitFrequency[i] > 0) {
                System.out.println(i + ": " + digitFrequency[i]);
            }
        }
    }
}

