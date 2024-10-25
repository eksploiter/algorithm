import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        int fashion = N * (N - 1);
        
        System.out.println(fashion);
        
        scanner.close();
    }
}