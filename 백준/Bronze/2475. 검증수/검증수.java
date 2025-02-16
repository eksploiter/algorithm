import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        for (int i = 0; i < 5; i++) {
            int a = scanner.nextInt();
            int doubleA = a * a;
            sum += doubleA;
        }

        int ans = sum % 10;

        System.out.println(ans);
        scanner.close();
    }
}