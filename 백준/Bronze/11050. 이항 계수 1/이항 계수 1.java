import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        
        int up = 1;
        int down = 1;
        
        for (int i = 0; i < K; i++) {
            up *= (N - i);
            down *= (K - i);
        }
        
        int answer = up / down;
        
        System.out.println(answer);
        
        scanner.close();
    }
}