import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 첫째 줄에 테스트 케이스의 개수 T를 입력받음
        int T = sc.nextInt();
        
        // 각 테스트 케이스마다 두 정수 A와 B를 입력받아 A+B를 출력
        for (int i = 0; i < T; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            System.out.println(A + B);
        }
        
        sc.close();
    }
}
