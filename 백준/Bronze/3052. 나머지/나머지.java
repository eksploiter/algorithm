import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 크기가 42인 boolean 배열을 사용하여 나머지가 존재하는지 표시
        boolean[] remainders = new boolean[42];

        // 10개의 숫자를 입력받음
        for (int i = 0; i < 10; i++) {
            int num = scanner.nextInt();
            int remainder = num % 42;
            remainders[remainder] = true; // 해당 나머지에 해당하는 인덱스를 true로 설정
        }

        // 서로 다른 나머지 개수를 셈
        int uniqueCount = 0;
        for (int i = 0; i < 42; i++) {
            if (remainders[i]) {
                uniqueCount++;
            }
        }

        // 결과 출력
        System.out.println(uniqueCount);

        scanner.close();
    }
}
