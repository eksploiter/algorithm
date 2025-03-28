import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        int a, b;

        if (input.length() == 2) {
            a = Character.getNumericValue(input.charAt(0));
            b = Character.getNumericValue(input.charAt(1));
        } else if (input.length() == 3) {
            if (input.startsWith("10")) {
                a = 10;
                b = Character.getNumericValue(input.charAt(2));
            } else {
                a = Character.getNumericValue(input.charAt(0));
                b = 10;
            }
        } else {
            a = 10;
            b = 10;
        }

        System.out.println(a + b);
    }
}
