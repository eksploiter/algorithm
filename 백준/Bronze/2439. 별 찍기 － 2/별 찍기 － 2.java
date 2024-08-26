import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 입력을 받기 위한 Scanner 객체 생성
        Scanner sc = new Scanner(System.in);
        
        // N 값을 입력 받음
        int N = sc.nextInt();
        
        // N개의 줄에 대해 반복
        for (int i = 1; i <= N; i++) {
            // 공백 출력: (N - i) 만큼 출력
            for (int j = 1; j <= N - i; j++) {
                System.out.print(" ");
            }
            // 별 출력: i 만큼 출력
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            // 줄바꿈
            System.out.println();
        }
        
        // Scanner 객체 닫기
        sc.close();
    }
}
