import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        scanner.close();
    }
}