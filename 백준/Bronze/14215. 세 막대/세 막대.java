import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        // 세 막대 중 가장 긴 변이 나머지 두 변의 합보다 크거나 같다면, 조정해줘야 함
        if (a >= b + c) {
            a = b + c - 1;
        } else if (b >= a + c) {
            b = a + c - 1;
        } else if (c >= a + b) {
            c = a + b - 1;
        }

        // 삼각형의 둘레 출력
        System.out.println(a + b + c);

        scanner.close();
    }
}
