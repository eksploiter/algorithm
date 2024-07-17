import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 테스트 케이스의 수를 입력받음
        int T = sc.nextInt();

        // 각 테스트 케이스를 처리
        for (int i = 1; i <= T; i++) {
            // 두 정수를 입력받음
            int a = sc.nextInt();
            int b = sc.nextInt();
            // 지정된 형식에 맞춰 결과를 출력
            System.out.println("Case #" + i + ": " + a + " + " + b + " = " + (a + b));
        }

        // 스캐너를 닫음
        sc.close();
    }
}
