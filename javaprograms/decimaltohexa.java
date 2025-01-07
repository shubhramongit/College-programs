import java.util.*;
public class decimaltohexa {
    public static String dectohexz(int decimal){
        if(decimal==0){
            return "0";
        }
        String hex=dectohexz(decimal/16);
        int rem=decimal%16;
        if(rem<10){
            return hex+rem;
        }
        else{
            return  hex+(char)('A' +(rem-10));

        }
        }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a decimal number");
        int decimal=sc.nextInt();
        String result= dectohexz(decimal);
        System.out.println("hexadecimal equivalent is "+result);
    }
}
