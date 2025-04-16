import java.io.*;
import java.util.*;

public class Main {
    static long[] tree;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 수의 개수
        int M = Integer.parseInt(st.nextToken()); // 변경 횟수
        int K = Integer.parseInt(st.nextToken()); // 합 구하는 횟수

        arr = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        int treeHeight = (int) Math.ceil(Math.log(N) / Math.log(2));
        int treeSize = 1 << (treeHeight + 1);
        tree = new long[treeSize];

        build(1, 1, N); // 트리 생성

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            long b = Long.parseLong(st.nextToken());

            if (cmd == 1) {
                update(1, 1, N, a, b - arr[a]); // 값 차이만큼 업데이트
                arr[a] = b;
            } else if (cmd == 2) {
                System.out.println(sum(1, 1, N, a, (int) b));
            }
        }
    }

    // 트리 생성
    static long build(int node, int start, int end) {
        if (start == end) return tree[node] = arr[start];
        int mid = (start + end) / 2;
        return tree[node] = build(node * 2, start, mid) + build(node * 2 + 1, mid + 1, end);
    }

    // 구간 합
    static long sum(int node, int start, int end, int left, int right) {
        if (right < start || end < left) return 0;
        if (left <= start && end <= right) return tree[node];
        int mid = (start + end) / 2;
        return sum(node * 2, start, mid, left, right) + sum(node * 2 + 1, mid + 1, end, left, right);
    }

    // 값 업데이트
    static void update(int node, int start, int end, int index, long diff) {
        if (index < start || index > end) return;
        tree[node] += diff;
        if (start != end) {
            int mid = (start + end) / 2;
            update(node * 2, start, mid, index, diff);
            update(node * 2 + 1, mid + 1, end, index, diff);
        }
    }
}
