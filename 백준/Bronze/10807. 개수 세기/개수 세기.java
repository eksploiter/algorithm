import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 첫째 줄 입력: 정수의 개수 N
        int N = scanner.nextInt();

        // 둘째 줄 입력: N개의 정수
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = scanner.nextInt();
        }

        // 셋째 줄 입력: 찾으려는 정수 v
        int v = scanner.nextInt();

        // 정수 v의 개수 세기
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (numbers[i] == v) {
                count++;
            }
        }

        // 결과 출력
        System.out.println(count);

        scanner.close();
    }
}
