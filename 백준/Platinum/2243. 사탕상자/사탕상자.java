import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static final int MAX = 1_000_000;
    static int[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        tree = new int[4 * MAX + 4];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            if (op == 1) {
                int rank = Integer.parseInt(st.nextToken());
                int taste = query(1, MAX, 1, rank);
                sb.append(taste).append('\n');
            } else { // op == 2
                int taste = Integer.parseInt(st.nextToken());
                int cnt = Integer.parseInt(st.nextToken());
                update(1, MAX, 1, taste, cnt);
            }
        }
        System.out.print(sb);
    }

    static int query(int start, int end, int node, int rank) {
        if (start == end) {
            update(1, MAX, 1, start, -1);
            return start;
        }
        int mid = (start + end) / 2;
        int leftSum = tree[node * 2];
        if (rank <= leftSum) {
            return query(start, mid, node * 2, rank);
        } else {
            return query(mid + 1, end, node * 2 + 1, rank - leftSum);
        }
    }

    static void update(int start, int end, int node, int taste, int cnt) {
        if (taste < start || taste > end) return;
        tree[node] += cnt;
        if (start == end) return;
        int mid = (start + end) / 2;
        update(start, mid, node * 2, taste, cnt);
        update(mid + 1, end, node * 2 + 1, taste, cnt);
    }
}
