import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        
        System.out.println(executeCount(n));
        System.out.println(3);
        
        scanner.close();
    }
    
    public static long executeCount(int n) {
        long sum = (long) n * (n - 1) * (n - 2) / 6;
        return sum;
    }
}