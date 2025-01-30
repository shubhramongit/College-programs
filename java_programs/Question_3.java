package java_programs;
import java.util.Scanner;
public class Question_3 {
	
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("Enter a string: ");
	        String input = scanner.nextLine();
	        scanner.close();

	        String result = "";

	        for (int i = 0; i < input.length(); i++) {
	            char c = input.charAt(i);
	            if (!result.contains(Character.toString(c))) {
	                result += c;
	            }
	        }

	        System.out.println("String after removing duplicate characters: " + result);
	    }
	}

