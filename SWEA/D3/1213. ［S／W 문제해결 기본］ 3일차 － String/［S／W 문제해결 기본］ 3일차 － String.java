import java.util.Scanner;

public class Solution {
    // 문자열 내에서 패턴의 등장 횟수를 세는 메소드
    public static int countPattern(String str, String pattern) {
        int count = 0;
        int index = 0;
        
        // 문자열 전체를 순회하면서 패턴 검색
        while ((index = str.indexOf(pattern, index)) != -1) {
            count++;
            index += 1; // 다음 위치부터 검색 계속
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 테스트 케이스 개수 입력
        int T = 10; // 문제에서 주어진 테스트 케이스 수
        
        for (int test_case = 1; test_case <= T; test_case++) {
            // 테스트 케이스 번호 입력
            int caseNum = sc.nextInt();
            sc.nextLine(); // 개행문자 처리
            
            // 찾을 패턴 문자열 입력
            String pattern = sc.nextLine().trim();
            
            // 검색할 전체 문자열 입력
            String text = sc.nextLine().trim();
            
            // 패턴 등장 횟수 계산
            int result = countPattern(text, pattern);
            
            // 결과 출력
            System.out.println("#" + caseNum + " " + result);
        }
        
        sc.close();
    }
}