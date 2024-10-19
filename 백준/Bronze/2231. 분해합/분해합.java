import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        int M = 0;
        
        for (int i = 0; i < N; i++) {
            int sum = i;
            int number = i;
            
            while (number != 0) {
                sum += number % 10;
                number /= 10;
            }
            
            if (sum == N) {
                M = i;
                break;
            }
        }
        
        System.out.println(M);
    }
}