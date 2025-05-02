import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= n; i++) {
            queue.add(i);
        }

        while(queue.size() >= k) {
            queue.add(queue.poll()); // 첫 번째 원소를 뒤로 보냄
            for(int i = 1; i < k; i++) {
                queue.poll(); // 그 다음 K-1개의 원소를 제거
            }
        }

        System.out.print(queue.peek()); // 마지막으로 남은 숫자 출력
    }
}
