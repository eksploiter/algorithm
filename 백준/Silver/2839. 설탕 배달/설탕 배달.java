import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int count = 0;

        // 5kg 봉지를 최대한 사용하고 남은 나머지를 3kg 봉지로 채운다.
        while (N >= 0) {
            // N이 5로 나누어 떨어지면 그 때의 봉지 개수를 계산하고 종료
            if (N % 5 == 0) {
                count += N / 5;
                System.out.println(count);
                return;
            }
            // 나누어 떨어지지 않으면 3kg 봉지 하나를 사용하고, N을 줄임
            N -= 3;
            count++;
        }

        // 3과 5의 조합으로 나눌 수 없을 때
        System.out.println(-1);
    }
}