import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            deque.addLast(i);
        }

        st = new StringTokenizer(br.readLine());
        int operations = 0;

        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            int idx = 0;
            for (int num : deque) {
                if (num == target) break;
                idx++;
            }

            int size = deque.size();
            if (idx <= size - idx) {
                for (int k = 0; k < idx; k++) {
                    deque.addLast(deque.removeFirst());
                }
                operations += idx;
            } else {
                int r = size - idx;
                for (int k = 0; k < r; k++) {
                    deque.addFirst(deque.removeLast());
                }
                operations += r;
            }
            deque.removeFirst();
        }

        System.out.print(operations);
    }
}
