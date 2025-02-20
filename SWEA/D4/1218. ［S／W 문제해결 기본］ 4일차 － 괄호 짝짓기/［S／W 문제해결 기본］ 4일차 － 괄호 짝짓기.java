import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = 10; // 첫 번째 줄에서 테스트 케이스 개수 읽기

        for (int tc = 1; tc <= T; tc++) { // 1부터 T까지 반복
            int len = Integer.parseInt(br.readLine().trim()); // 괄호 문자열의 길이
            String input = br.readLine().trim();

            sb.append("#").append(tc).append(" ").append(isValid(input)).append("\n");
        }

        System.out.print(sb);
    }

    static int isValid(String input) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> matching = new HashMap<>();
        matching.put(')', '(');
        matching.put('}', '{');
        matching.put(']', '[');
        matching.put('>', '<');

        for (char ch : input.toCharArray()) {
            if (matching.containsValue(ch)) { // 여는 괄호라면 push
                stack.push(ch);
            } else if (matching.containsKey(ch)) { // 닫는 괄호라면 매칭 확인
                if (stack.isEmpty() || stack.pop() != matching.get(ch)) {
                    return 0; // 잘못된 괄호 쌍
                }
            }
        }

        return stack.isEmpty() ? 1 : 0; // 스택이 비어 있어야 올바른 괄호
    }
}
