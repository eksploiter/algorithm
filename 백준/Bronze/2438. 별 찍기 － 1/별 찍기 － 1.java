import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 입력을 받기 위한 Scanner 객체 생성
        Scanner scanner = new Scanner(System.in);
        
        // N을 입력받음
        int N = scanner.nextInt();
        
        // 1부터 N까지 반복하면서 각 줄에 별을 출력
        for (int i = 1; i <= N; i++) {
            // i개의 별을 출력
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            // 줄 바꿈
            System.out.println();
        }
        
        // Scanner 객체 닫기
        scanner.close();
    }
}
