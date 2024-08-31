import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt(); // 바구니의 수
        int M = sc.nextInt(); // 공을 교환할 횟수
        
        // 초기 상태: 각 바구니에 자기 번호와 동일한 공이 들어있음
        int[] baskets = new int[N + 1]; // 바구니 번호는 1번부터 시작하므로 0번 인덱스는 사용하지 않음
        for (int i = 1; i <= N; i++) {
            baskets[i] = i;
        }
        
        // 공을 교환하는 과정
        for (int k = 0; k < M; k++) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            
            // i번 바구니와 j번 바구니에 있는 공을 교환
            int temp = baskets[i];
            baskets[i] = baskets[j];
            baskets[j] = temp;
        }
        
        // 최종 결과 출력
        for (int i = 1; i <= N; i++) {
            System.out.print(baskets[i] + " ");
        }
    }
}
