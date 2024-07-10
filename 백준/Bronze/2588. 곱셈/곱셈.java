import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        String number = Integer.toString(b);

        int hundreds = Character.getNumericValue(number.charAt(0));
        int ten = Character.getNumericValue(number.charAt(1));
        int units = Character.getNumericValue(number.charAt(2));

        System.out.println(a*units);
        System.out.println(a*ten);
        System.out.println(a*hundreds);
        System.out.println(a*b);
        
        sc.close();
    }
}