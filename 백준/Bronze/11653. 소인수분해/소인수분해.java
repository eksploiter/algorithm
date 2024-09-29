import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        
        // 1인 경우 아무것도 출력하지 않음
        if (N == 1) {
            return;
        }
        
        // 2부터 시작해서 N을 나누기
        for (int i = 2; i * i <= N; i++) {
            while (N % i == 0) {
                System.out.println(i);
                N /= i;
            }
        }
        
        // 마지막으로 남은 N이 1이 아니면 그 값도 출력
        if (N > 1) {
            System.out.println(N);
        }
        
        scanner.close();
    }
}
