import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = rectangle(a, b);
        
        System.out.println(c);
    }
    
    public static int rectangle(int a, int b) {
        return a * b;
    }
}