import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 큰 정수를 다루기 위해 long 타입 사용
        long a = sc.nextLong();
        long b = sc.nextLong();
        long c = sc.nextLong();
        
        // 세 수의 합 계산
        long sum = a + b + c;
        
        // 결과 출력
        System.out.println(sum);
        
        sc.close();
    }
}
