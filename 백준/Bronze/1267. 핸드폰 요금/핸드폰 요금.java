import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int Y = 0;
        int M = 0;
        int[] call = new int[T];
        for (int i = 0; i < T; i++) {
            call[i] = scanner.nextInt();
        }
        
        for (int i = 0; i < T; i++) {
            Y += (call[i] / 30 + 1) * 10;
            M += (call[i] / 60 + 1) * 15;
        }
        
        if (Y < M) {
            System.out.println("Y " + Y);
        } else if (M < Y) {
            System.out.println("M " + M);
        } else {
            System.out.println("Y M " + Y);
        }
        
        scanner.close();
    }
}