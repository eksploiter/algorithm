import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 첫째 줄에 테스트 케이스의 개수 T를 입력받음
        int T = sc.nextInt();
        sc.nextLine();  // 개행 문자 처리
        
        // 각 테스트 케이스의 결과를 저장할 배열
        int[] results = new int[T];
        
        // 각 테스트 케이스마다 A와 B를 입력받아 결과를 계산 후 저장
        for (int i = 0; i < T; i++) {
            String input = sc.nextLine();
            String[] numbers = input.split(",");
            int A = Integer.parseInt(numbers[0]);
            int B = Integer.parseInt(numbers[1]);
            results[i] = A + B;
        }
        
        // 모든 입력이 끝난 후에 결과를 출력
        for (int result : results) {
            System.out.println(result);
        }
        
        sc.close();
    }
}
