import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[9];
        int totalSum = 0;

        // 키 입력 및 총합 계산
        for (int i = 0; i < 9; i++) {
            arr[i] = scanner.nextInt();
            totalSum += arr[i];
        }

        boolean found = false; // 두 난쟁이를 찾았는지 여부를 확인하는 변수

        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (totalSum - arr[i] - arr[j] == 100) {
                    arr[i] = arr[j] = -1; // 제외할 난쟁이의 키를 -1로 설정
                    found = true; // 두 난쟁이를 찾았음을 표시
                    break; // 내부 루프 종료
                }
            }
            if (found) break; // 외부 루프 종료
        }

        // 결과 출력
        Arrays.sort(arr); // -1을 앞으로 정렬
        for (int i = 2; i < 9; i++) { // -1을 제외한 나머지 7명의 키 출력
            System.out.println(arr[i]);
        }
    }
}
