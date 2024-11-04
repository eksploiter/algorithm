import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            int lcm = lcm(A, B);
            System.out.println(lcm);
        }
        scanner.close();
    }
    public static int lcm(int A, int B) {
        return (A * B) / gcd(A, B);
    }
    public static int gcd(int A, int B) {
        while (B != 0) {
            int temp = B;
            B = A % B;
            A = temp;
        }
        return A;
    }
} 