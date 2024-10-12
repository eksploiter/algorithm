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
import java.util.HashMap;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        // 구멍의 개수를 저장한 해시맵
        HashMap<Character, Integer> holeMap = new HashMap<>();
        
        // 구멍이 없는 문자들
        String zeroHoles = "CEFGHIJKLMNSTUVWXYZ";
        // 구멍이 1개 있는 문자들
        String oneHole = "ADOPQR";
        // 구멍이 2개 있는 문자들
        char twoHoles = 'B';

        // 구멍이 없는 문자들을 0으로 설정
        for (char c : zeroHoles.toCharArray()) {
            holeMap.put(c, 0);
        }
        // 구멍이 1개 있는 문자들을 1로 설정
        for (char c : oneHole.toCharArray()) {
            holeMap.put(c, 1);
        }
        // B는 구멍이 2개
        holeMap.put(twoHoles, 2);

        // 입력 받기
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스 개수
        sc.nextLine(); // 개행 문자 처리

        // 테스트 케이스마다 비교
        for (int t = 1; t <= T; t++) {
            // 두 문자열 입력 받기
            String[] strings = sc.nextLine().split(" ");
            String str1 = strings[0];
            String str2 = strings[1];

            // 두 문자열의 길이가 다르면 바로 다르다고 출력
            if (str1.length() != str2.length()) {
                System.out.println("#" + t + " DIFF");
                continue;
            }

            boolean isSame = true;

            // 문자열을 문자별로 비교
            for (int i = 0; i < str1.length(); i++) {
                char c1 = str1.charAt(i);
                char c2 = str2.charAt(i);

                // 같은 구멍의 개수인지 비교
                if (!holeMap.get(c1).equals(holeMap.get(c2))) {
                    isSame = false;
                    break;
                }
            }

            // 결과 출력
            if (isSame) {
                System.out.println("#" + t + " SAME");
            } else {
                System.out.println("#" + t + " DIFF");
            }
        }
        sc.close();
    }
}
