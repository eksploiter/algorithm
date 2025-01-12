import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] scores = new int[N];

        for (int i = 0; i < N; i++) {
            scores[i] = scanner.nextInt();
        }

        int M = scores[0];
        for (int i = 1; i < N; i++) {
            if (scores[i] > M) {
                M = scores[i];
            }
        }

        double total = 0;
        for (int i = 0; i < N; i++) {
            total += ((double) scores[i] / M) * 100;
        }
        double average =  total / N;
        System.out.println(average);
    }
}
