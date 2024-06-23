import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        // 문자열의 길이 구하기
        int len = str.length();

        // 문자열을 시계방향으로 90도 돌려서 출력
        for (int i = 0; i < len; i++) {
            System.out.println(str.charAt(i));
        }

        sc.close();
    }
}