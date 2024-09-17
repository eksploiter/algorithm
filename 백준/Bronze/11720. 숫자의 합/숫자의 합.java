import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();  // 숫자의 개수 입력
        String numbers = scanner.next();  // 공백 없이 이어진 숫자 문자열 입력

        int total = 0;

        // 문자열을 순회하며 각 문자를 숫자로 변환하고 합산
        for (int i = 0; i < N; i++) {
            total += numbers.charAt(i) - '0';  // char를 int로 변환
        }

        System.out.println(total);  // 합계 출력
        scanner.close();
    }
}
