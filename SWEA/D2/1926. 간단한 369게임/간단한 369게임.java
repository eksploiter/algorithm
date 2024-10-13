import java.util.Scanner;
 
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
 
        int T = scanner.nextInt(); // 입력받은 수 T까지 게임을 진행
        for (int i = 1; i <= T; i++) {
            String numStr = Integer.toString(i); // 숫자를 문자열로 변환
            int clapCount = 0; // 박수 횟수를 카운트하는 변수
 
            // 각 자리 수가 3, 6, 9인지 확인
            for (int j = 0; j < numStr.length(); j++) {
                char ch = numStr.charAt(j);
                if (ch == '3' || ch == '6' || ch == '9') {
                    clapCount++;
                }
            }
 
            // 박수 횟수에 따라 출력
            if (clapCount > 0) {
                for (int k = 0; k < clapCount; k++) {
                    System.out.print("-");
                }
                System.out.print(" ");
            } else {
                System.out.print(i + " ");
            }
        }
 
        scanner.close();
    }
}