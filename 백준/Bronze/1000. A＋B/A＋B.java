import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Scanner 객체 생성
        Scanner scanner = new Scanner(System.in);
        
        // 두 정수 A와 B 입력받기
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        
        // A와 B를 더하여 결과 출력
        System.out.println(A + B);
        
        // Scanner 닫기
        scanner.close();
    }
}