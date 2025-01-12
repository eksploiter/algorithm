import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] scores = new int[N];
        for (int i = 0; i < N; i++) {
            scores[i] = scanner.nextInt();
        }
        double sum = 0;
        double maxScore = 0;
        for (int i = 0; i < N; i++) {
            if (scores[i] > maxScore) {
                maxScore = scores[i];
            }
        }
        for (int i = 0; i < N; i++) {
            sum += (double) scores[i] / maxScore * 100;
        }
        double average = sum / N;
        System.out.println(average);
        scanner.close();
    }
}