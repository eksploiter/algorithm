import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String A = scanner.next();
        String B = scanner.next();

        int reverseA = reverseNumber(A);
        int reverseB = reverseNumber(B);

        System.out.println(Math.max(reverseA, reverseB));

        scanner.close();
    }

    public static int reverseNumber(String num) {
        StringBuilder sb = new StringBuilder(num);
        return Integer.parseInt((sb.reverse().toString()));
    }
}