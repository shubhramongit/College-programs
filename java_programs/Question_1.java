package java_programs;

import java.util.Scanner;

public class Question_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String input = sc.nextLine();
        sc.close();
         int []charFrequency=new int[256];

        for (int i = 0; i < input.length(); i++) {
        	 char c = input.charAt(i);
        	 charFrequency[c]++;
        }

        System.out.println("Character frequencies:");
        for (int i = 0; i < charFrequency.length; i++) {
            if (charFrequency[i] > 0) {
                System.out.println((char) i + ": " + charFrequency[i]);
            }
        }
    }
}
