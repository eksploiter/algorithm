import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] commands = new int[n];
        for (int i = 0; i < n; i++) {
            commands[i] = Integer.parseInt(st.nextToken());
        }
        
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            int cmd = commands[i];
            int card = n - i;
            
            if (cmd == 1) {
                deque.addFirst(card);
            } else if (cmd == 2) {
                if (!deque.isEmpty()) {
                    int first = deque.pollFirst();
                    deque.addFirst(card);
                    deque.addFirst(first);
                } else {
                    deque.addFirst(card);
                }
            } else if (cmd == 3) {
                deque.addLast(card);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int card : deque) {
            sb.append(card).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
