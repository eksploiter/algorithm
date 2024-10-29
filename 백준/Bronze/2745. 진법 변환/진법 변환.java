import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String n = scanner.next();
        int b = scanner.nextInt();
        
        // Character.digit() -> 메서드를 사용해서 B진법 수를 10진법으로 변환
        long result = 0;
        for (int i = 0; i < n.length(); i++) {
            result = result * b + Character.digit(n.charAt(i), b);
        }
        
        System.out.println(result);
        scanner.close();
    }
}