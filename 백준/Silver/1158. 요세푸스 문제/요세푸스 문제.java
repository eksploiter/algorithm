import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Integer> queue = new LinkedList<>();

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        while (!queue.isEmpty()) {
            for (int i = 1; i < K; i++) {
                queue.add(queue.poll());  // K-1명은 뒤로 보냄
            }
            sb.append(queue.poll());     // K번째는 제거
            if (!queue.isEmpty()) {
                sb.append(", ");
            }
        }

        sb.append(">");
        System.out.println(sb);
    }
}
