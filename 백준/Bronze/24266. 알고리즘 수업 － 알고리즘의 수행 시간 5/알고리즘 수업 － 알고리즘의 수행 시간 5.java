import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        
        long executeCount = (long) n * n * n;
        
        System.out.println(executeCount);
        System.out.println(3);
        
        scanner.close();
    }
}