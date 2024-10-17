import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        long lineLength = (long) n * 4;
        
        System.out.println(lineLength);
        
        scanner.close();
    }
}