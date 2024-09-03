import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // N: 바구니의 개수, M: 순서를 뒤집는 횟수
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        // 1번부터 N번까지 바구니 번호를 배열로 초기화
        int[] baskets = new int[N];
        for (int i = 0; i < N; i++) {
            baskets[i] = i + 1;
        }

        // M번 동안 순서를 뒤집는 작업 수행
        for (int m = 0; m < M; m++) {
            int i = scanner.nextInt() - 1;  // 시작 인덱스 (0부터 시작하기 위해 -1)
            int j = scanner.nextInt() - 1;  // 종료 인덱스 (0부터 시작하기 위해 -1)
            
            // i부터 j까지의 범위를 역순으로 바꿈
            while (i < j) {
                int temp = baskets[i];
                baskets[i] = baskets[j];
                baskets[j] = temp;
                i++;
                j--;
            }
        }

        // 결과 출력
        for (int basket : baskets) {
            System.out.print(basket + " ");
        }
    }
}
