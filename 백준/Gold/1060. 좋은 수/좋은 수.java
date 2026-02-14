import java.io.*;
import java.util.*;

public class Main {

    static class Range {
        int start, end;     // (start, end) 사이 숫자들이 후보
        long len;           // end - start - 1
        long maxIter;       // ceil(len / 2)
        long iter = 0;      // 현재까지 생성한 깊이
        Range(int start, int end) {
            this.start = start;
            this.end = end;
            this.len = (long) end - start - 1;
            this.maxIter = (len + 1) / 2; // ceil(len/2)
        }
    }

    static class Node {
        long score;
        int num;
        int rangeIdx;
        boolean triggerNext; // true면 이 노드를 뽑는 순간 다음 iter 후보를 생성
        Node(long score, int num, int rangeIdx, boolean triggerNext) {
            this.score = score;
            this.num = num;
            this.rangeIdx = rangeIdx;
            this.triggerNext = triggerNext;
        }
    }

    static void addCandidates(PriorityQueue<Node> pq, Range[] ranges, int idx) {
        Range r = ranges[idx];
        if (r.iter >= r.maxIter) return;   // 더 이상 후보 없음
        r.iter++;
        long t = r.iter;

        // k = start + t (왼쪽), k = end - t (오른쪽)
        // score = (k-start)*(end-k) - 1 = t*(len - t + 1) - 1
        long score = t * (r.len - t + 1) - 1;

        // len이 홀수이고 t가 마지막이면 가운데 하나만
        if (t == r.maxIter && (r.len % 2 == 1)) {
            int mid = (int) (r.end - t); // start+t == end-t
            pq.offer(new Node(score, mid, idx, true));
        } else {
            int left = (int) (r.start + t);
            int right = (int) (r.end - t);
            pq.offer(new Node(score, left, idx, false));
            pq.offer(new Node(score, right, idx, true)); // 오른쪽을 뽑으면 다음 깊이 생성
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine().trim());
        int[] s = new int[L];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < L; i++) s[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(s);

        int N = Integer.parseInt(br.readLine().trim());

        // ranges[i]는 i번째 S 원소 앞의 구간: (prev, s[i])
        Range[] ranges = new Range[L];
        ranges[0] = new Range(0, s[0]);
        for (int i = 1; i < L; i++) ranges[i] = new Range(s[i - 1], s[i]);

        PriorityQueue<Node> pq = new PriorityQueue<>(
                (a, b) -> {
                    if (a.score != b.score) return Long.compare(a.score, b.score);
                    return Integer.compare(a.num, b.num);
                }
        );

        // S의 원소는 score=0으로 먼저 후보에 넣기 + 각 구간의 첫 후보 생성
        for (int i = 0; i < L; i++) {
            pq.offer(new Node(0L, s[i], i, false));
            addCandidates(pq, ranges, i);
        }

        StringBuilder sb = new StringBuilder();
        int count = 0;
        int tail = 1; // pq가 비면 s[last] + 1, +2 ... 출력

        while (count < N) {
            int val;
            if (!pq.isEmpty()) {
                Node cur = pq.poll();
                val = cur.num;
                if (cur.triggerNext) addCandidates(pq, ranges, cur.rangeIdx);
            } else {
                val = s[L - 1] + tail;
                tail++;
            }

            if (count > 0) sb.append(' ');
            sb.append(val);
            count++;
        }

        System.out.println(sb);
    }
}
