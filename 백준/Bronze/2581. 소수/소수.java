import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int M = scanner.nextInt();
        int N = scanner.nextInt();
        int sum = 0;
        int minPrime = -1;
        
        for (int i = M; i <= N; i++) {
            if (isPrime(i)) {
                sum += i;
                if (minPrime == -1) {
                    minPrime = i;  // 첫 번째 소수를 최솟값으로 설정
                }
            }
        }
        
        if (minPrime == -1) {
            System.out.println(-1);  // 소수가 없을 경우
        } else {
            System.out.println(sum);
            System.out.println(minPrime);
        }
        
        scanner.close();
    }
    
    public static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
