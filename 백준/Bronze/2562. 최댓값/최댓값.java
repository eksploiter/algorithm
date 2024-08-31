import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int max = 0; // 최댓값을 저장할 변수
        int index = 0; // 최댓값이 몇 번째 수인지 저장할 변수

        for (int i = 1; i <= 9; i++) {
            int number = scanner.nextInt();
            if (number > max) {
                max = number;
                index = i;
            }
        }

        System.out.println(max);   // 최댓값 출력
        System.out.println(index); // 최댓값이 몇 번째 수인지 출력
    }
}
