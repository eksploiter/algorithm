import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int count = 0;

        for (int i = 0; i < N; i++) {
            int num = scanner.nextInt();
            if (isPrime(num)) {
                count++;
            }
        }

        System.out.println(count);

        scanner.close();
    }

    // 소수를 판별하는 메서드
    public static boolean isPrime(int num) {
        if (num < 2) { // 2보다 작은 수는 소수가 아님
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) { // 제곱근까지 확인
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
