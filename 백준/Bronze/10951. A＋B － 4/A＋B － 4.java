import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (scanner.hasNext()) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            
            System.out.println(A + B);
        }
    }
}