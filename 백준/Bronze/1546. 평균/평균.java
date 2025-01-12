import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] scores = new int[N];
        for (int i = 0; i < N; i++) {
            scores[i] = scanner.nextInt();
        }
        double highScore = 0;
        double sum = 0;
        for (int i = 0; i < N; i++) {
            if (scores[i] > highScore) {
                highScore = scores[i];
            }
            sum += scores[i];
        }
        System.out.println(sum * 100 / highScore / N);
        scanner.close();
    }
}