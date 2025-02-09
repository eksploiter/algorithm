import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        
        for (int t = 0; t < T; t++) {
            int H = scanner.nextInt();
            int W = scanner.nextInt();
            int N = scanner.nextInt();
            
            if (N % H == 0) {
                System.out.println((H * 100) + (N / H));
            } else {
                System.out.println((N % H) * 100 + (N / H) + 1);
            }
        }
        
        scanner.close();
    } 
}