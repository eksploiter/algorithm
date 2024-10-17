import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 첫 번째 줄에서 숫자의 개수 N을 입력 받음
        int N = scanner.nextInt();
        
        // N개의 숫자를 담을 배열 생성
        int[] numbers = new int[N];
        
        // 숫자 입력 받기
        for (int i = 0; i < N; i++) {
            numbers[i] = scanner.nextInt();
        }
        
        // 배열을 오름차순으로 정렬
        Arrays.sort(numbers);
        
        // 정렬된 배열 출력
        for (int i = 0; i < N; i++) {
            System.out.println(numbers[i]);
        }

        scanner.close();
    }
}
