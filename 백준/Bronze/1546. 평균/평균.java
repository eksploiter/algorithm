import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] scores = new int[N];

        for (int i = 0; i < N; i++) {
            scores[i] = scanner.nextInt();
        }

        int max = scores[0];
        for (int i = 1; i < N; i++) {
            if (scores[i] > max) {
                max = scores[i];
            }
        }

        double total = 0;
        for (int i = 0; i < N; i++) {
            total += ((double) scores[i] / max) * 100;
        }

        double average = total / N;
        System.out.println(average);
    }
}
