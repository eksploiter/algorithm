import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        System.out.println(executeCount(n));
        System.out.println(2);

        scanner.close();
    }

    public static long executeCount(int n) {
        return (long) n * (n - 1) / 2;
    }
}