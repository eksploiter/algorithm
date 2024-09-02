import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 첫째 줄에 테스트 케이스의 개수 T를 입력받음
        int T = sc.nextInt();
        sc.nextLine();  // 개행 문자 처리
        
        // 각 테스트 케이스마다 A와 B를 입력받아 처리
        for (int i = 0; i < T; i++) {
            // 각 줄에 A,B 형태로 입력이 들어옴
            String input = sc.nextLine();
            
            // 콤마(,)로 분리하여 A와 B를 추출
            String[] numbers = input.split(",");
            int A = Integer.parseInt(numbers[0]);
            int B = Integer.parseInt(numbers[1]);
            
            // A + B를 출력
            System.out.println(A + B);
        }
        
        sc.close();
    }
}
