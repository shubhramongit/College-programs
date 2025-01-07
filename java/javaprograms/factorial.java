import java.util.Scanner;

public class factorial {
    public static int fact(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        
        int result = fact(num);
        System.out.println("The factorial of " + num + " is: " + result);
    }
}
