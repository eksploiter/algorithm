import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] number = new int[N];

        // 배열 입력과 동시에 최댓값과 최솟값 찾기
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            number[i] = scanner.nextInt();
            if (number[i] > max) {
                max = number[i];
            }
            if (number[i] < min) {
                min = number[i];
            }
        }

        System.out.println(min + " " + max);
    }
}
