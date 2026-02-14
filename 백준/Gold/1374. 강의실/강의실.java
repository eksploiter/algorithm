import java.io.*;
import java.util.*;

public class Main {

    static class Lecture {
        int s, e;
        Lecture(int s, int e) { this.s = s; this.e = e; }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Lecture[] arr = new Lecture[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken(); // 강의 번호는 필요 없음
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[i] = new Lecture(s, e);
        }

        Arrays.sort(arr, (a, b) -> {
            if (a.s != b.s) return a.s - b.s;
            return a.e - b.e;
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 종료시간들
        int ans = 0;

        for (Lecture lec : arr) {
            if (!pq.isEmpty() && pq.peek() <= lec.s) {
                pq.poll(); // 가장 빨리 끝난 강의실 재사용
            }
            pq.offer(lec.e);
            ans = Math.max(ans, pq.size());
        }

        System.out.println(ans);
    }
}
