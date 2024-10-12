/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner scanner = new Scanner(System.in);
        
        for (int t = 1; t <= 10; t++) {
            int testCaseNum = scanner.nextInt(); // 테스트 케이스 번호 입력
            
            int[][] matrix = new int[100][100];
            
            // 100x100 배열 입력 받기
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            
            int maxSum = 0;
            
            // 각 행의 합과 각 열의 합을 동시에 계산
            for (int i = 0; i < 100; i++) {
                int rowSum = 0;
                int colSum = 0;
                for (int j = 0; j < 100; j++) {
                    rowSum += matrix[i][j]; // 행의 합
                    colSum += matrix[j][i]; // 열의 합
                }
                maxSum = Math.max(maxSum, Math.max(rowSum, colSum));
            }
            
            // 대각선의 합 계산
            int diagonal1Sum = 0;
            int diagonal2Sum = 0;
            for (int i = 0; i < 100; i++) {
                diagonal1Sum += matrix[i][i];
                diagonal2Sum += matrix[i][99 - i];
            }
            maxSum = Math.max(maxSum, Math.max(diagonal1Sum, diagonal2Sum));
            
            // 결과 출력
            System.out.println("#" + testCaseNum + " " + maxSum);
        }
        scanner.close();
    }
}