import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt(); // 테스트 케이스 개수 입력받음

        for (int i = 0; i < T; i++) {
            int C = scanner.nextInt(); // 각 테스트 케이스의 거스름돈 C
            int quarters = C / 25; // 쿼터 계산 (25센트)
            C %= 25; // 나머지 거스름돈
            int dimes = C / 10; // 다임 계산 (10센트)
            C %= 10; // 나머지 거스름돈
            int nickels = C / 5; // 니켈 계산 (5센트)
            C %= 5; // 나머지 거스름돈
            int pennies = C; // 페니 계산 (1센트)

            System.out.println(quarters + " " + dimes + " " + nickels + " " + pennies);
        }

        scanner.close();
    }
}