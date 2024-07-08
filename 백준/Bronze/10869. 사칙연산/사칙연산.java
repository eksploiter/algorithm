import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 입력 받기
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        // 계산 및 출력
        System.out.println((a + b));  // 덧셈
        System.out.println((a - b));  // 뺄셈
        System.out.println((a * b));  // 곱셈
        System.out.println((a / b));  // 나눗셈의 몫
        System.out.println((a % b));  // 나머지
        
        sc.close();
    }
}
