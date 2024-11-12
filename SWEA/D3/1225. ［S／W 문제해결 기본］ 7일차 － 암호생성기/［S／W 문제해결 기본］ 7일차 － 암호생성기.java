import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 10개의 테스트 케이스 처리
        for (int t = 1; t <= 10; t++) {
            int caseNumber = scanner.nextInt();  // 테스트 케이스 번호
            int[] arr = new int[8];  // 8개의 숫자를 담을 배열
            
            // 8개의 숫자 입력 받기
            for (int i = 0; i < 8; i++) {
                arr[i] = scanner.nextInt();
            }
            
            boolean isComplete = false;
            
            // 암호 생성 과정
            while (!isComplete) {
                // 한 사이클 수행
                for (int i = 1; i <= 5; i++) {
                    // 첫 번째 숫자를 i만큼 감소
                    arr[0] = arr[0] - i;
                    
                    // 0 이하가 되면 0으로 설정
                    if (arr[0] <= 0) {
                        arr[0] = 0;
                        isComplete = true;
                    }
                    
                    // 숫자 순환 (0이 되었을 때도 한 번 더 순환)
                    int temp = arr[0];
                    for (int j = 0; j < 7; j++) {
                        arr[j] = arr[j + 1];
                    }
                    arr[7] = temp;
                    
                    // 0이 되었다면 순환 후 종료
                    if (isComplete) {
                        break;
                    }
                }
            }
            
            // 결과 출력
            System.out.print("#" + caseNumber + " ");
            for (int i = 0; i < 8; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
        
        scanner.close();
    }
}