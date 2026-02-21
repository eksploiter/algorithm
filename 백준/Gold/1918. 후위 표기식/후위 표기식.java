import java.io.*;
import java.util.*;

public class Main {
    private static int prec(char op) {
        if (op == '*' || op == '/') return 2;
        if (op == '+' || op == '-') return 1;
        return 0; // '(' 등
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();

        StringBuilder out = new StringBuilder();
        Deque<Character> st = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c >= 'A' && c <= 'Z') {              // 피연산자
                out.append(c);
            } else if (c == '(') {                    // 여는 괄호
                st.push(c);
            } else if (c == ')') {                    // 닫는 괄호: '(' 나올 때까지 pop
                while (!st.isEmpty() && st.peek() != '(') {
                    out.append(st.pop());
                }
                if (!st.isEmpty() && st.peek() == '(') st.pop(); // '(' 제거
            } else {                                  // 연산자
                while (!st.isEmpty() && st.peek() != '('
                        && prec(st.peek()) >= prec(c)) {
                    out.append(st.pop());
                }
                st.push(c);
            }
        }

        while (!st.isEmpty()) {                       // 남은 연산자 처리
            out.append(st.pop());
        }

        System.out.print(out.toString());
    }
}