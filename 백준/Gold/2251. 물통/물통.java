import java.io.*;
import java.util.*;

public class Main {
    static int A, B, C;
    static boolean[][][] visited;
    static Set<Integer> result = new TreeSet<>();

    static class State {
        int a, b, c;
        State(int a, int b, int c) {
            this.a = a; this.b = b; this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        visited = new boolean[A+1][B+1][C+1];
        bfs();

        StringBuilder sb = new StringBuilder();
        for (int x : result) {
            sb.append(x).append(' ');
        }
        System.out.println(sb.toString().trim());
    }

    static void bfs() {
        Queue<State> queue = new ArrayDeque<>();
        queue.add(new State(0, 0, C));

        while (!queue.isEmpty()) {
            State st = queue.poll();
            int a = st.a, b = st.b, c = st.c;
            if (visited[a][b][c]) continue;
            visited[a][b][c] = true;

            if (a == 0) result.add(c);

            // 여섯 가지 물 이동
            pour(queue, a, b, c, 0, 1); // A->B
            pour(queue, a, b, c, 0, 2); // A->C
            pour(queue, a, b, c, 1, 0); // B->A
            pour(queue, a, b, c, 1, 2); // B->C
            pour(queue, a, b, c, 2, 0); // C->A
            pour(queue, a, b, c, 2, 1); // C->B
        }
    }

    static void pour(Queue<State> queue,
                     int a, int b, int c,
                     int fromIdx, int toIdx) {
        int[] cur = {a, b, c};
        int[] cap = {A, B, C};

        if (cur[fromIdx] == 0) return;

        int amount = Math.min(cur[fromIdx], cap[toIdx] - cur[toIdx]);
        cur[fromIdx] -= amount;
        cur[toIdx] += amount;

        State next = new State(cur[0], cur[1], cur[2]);
        if (!visited[next.a][next.b][next.c]) {
            queue.add(next);
        }
    }
}
