import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String input = br.readLine();

            Deque<Character> left = new LinkedList<>();
            Deque<Character> right = new LinkedList<>();

            for (char ch : input.toCharArray()) {
                switch(ch) {
                    case '<':
                        if (!left.isEmpty()) {
                            right.addFirst(left.pollLast());
                        }
                        break;
                    case '>':
                        if (!right.isEmpty()) {
                            left.addLast(right.pollFirst());
                        }
                        break;
                    case '-':
                        if (!left.isEmpty()) {
                            left.pollLast();
                        }
                        break;
                    default:
                        left.addLast(ch);
                        break;
                }
            }

            for (char ch : left) sb.append(ch);
            for (char ch : right) sb.append(ch);
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
