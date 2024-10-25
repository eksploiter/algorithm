import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        int c = (int) Math.pow(2, N);
        
        System.out.println(c);
        
        scanner.close();
    }
}