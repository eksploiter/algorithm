import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            
            // 종료 조건
            if (a == 0 && b == 0 && c == 0) {
                break;
            }
            
            // 삼각형의 유효성 검사
            if (a >= b + c || b >= a + c || c >= a + b) {
                System.out.println("Invalid");
                continue;  // 유효하지 않은 경우 다음 반복으로 넘어감
            }
            
            // 삼각형의 종류 판단
            if (a == b && b == c) {
                System.out.println("Equilateral");
            } else if (a == b || a == c || b == c) {
                System.out.println("Isosceles");
            } else {
                System.out.println("Scalene");
            }
        }
        scanner.close();
    }
}