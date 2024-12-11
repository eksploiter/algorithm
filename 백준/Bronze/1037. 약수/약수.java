import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); // 진짜 약수의 개수
        int[] arr = new int[N];
        
        // 진짜 약수 입력
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }
        
        // 배열 정렬
        Arrays.sort(arr);
        
        // N 계산: 최솟값 * 최댓값
        int answer = arr[0] * arr[N - 1];
        System.out.println(answer);
        
        scanner.close();
    }
}
