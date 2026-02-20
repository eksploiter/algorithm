import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream in) {
            this.in = in;
        }

        private int readByte() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        String next() throws IOException {
            int c;
            do {
                c = readByte();
                if (c == -1) return null;
            } while (c <= ' ');

            StringBuilder sb = new StringBuilder();
            while (c > ' ') {
                sb.append((char) c);
                c = readByte();
                if (c == -1) break;
            }
            return sb.toString();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    static Map<String, Integer> idMap = new HashMap<>();
    static ArrayList<Integer>[] g;

    static int getId(String s) {
        Integer id = idMap.get(s);
        if (id != null) return id;
        int newId = idMap.size();
        idMap.put(s, newId);
        return newId;
    }

    static int V;
    static int[] disc, low, sccId;
    static boolean[] onStack;
    static int time = 0, sccCnt = 0;
    static Deque<Integer> stack = new ArrayDeque<>();
    static ArrayList<int[]> sccNodes;

    static ArrayList<int[]> sccNodeLists;
    static ArrayList<ArrayList<Integer>> sccNodeVec;

    static void tarjanInit(int n) {
        V = n;
        disc = new int[V];
        low = new int[V];
        sccId = new int[V];
        onStack = new boolean[V];
        Arrays.fill(disc, -1);
        Arrays.fill(sccId, -1);
        time = 0;
        sccCnt = 0;
        stack.clear();
        sccNodeVec = new ArrayList<>();
    }

    static void dfs(int u) {
        disc[u] = low[u] = time++;
        stack.push(u);
        onStack[u] = true;

        for (int v : g[u]) {
            if (disc[v] == -1) {
                dfs(v);
                low[u] = Math.min(low[u], low[v]);
            } else if (onStack[v]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }

        if (low[u] == disc[u]) {
            ArrayList<Integer> comp = new ArrayList<>();
            while (true) {
                int x = stack.pop();
                onStack[x] = false;
                sccId[x] = sccCnt;
                comp.add(x);
                if (x == u) break;
            }
            sccNodeVec.add(comp);
            sccCnt++;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int N = Integer.parseInt(fs.next());

        int cap = 2600;
        g = new ArrayList[cap];
        for (int i = 0; i < cap; i++) g[i] = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String target = fs.next();
            int m = Integer.parseInt(fs.next());

            int tid = getId(target);
            // 용량 부족 시 확장
            if (tid >= g.length) {
                g = Arrays.copyOf(g, g.length * 2);
                for (int k = cap; k < g.length; k++) g[k] = new ArrayList<>();
                cap = g.length;
            }

            for (int j = 0; j < m; j++) {
                String src = fs.next();
                int sid = getId(src);
                if (sid >= g.length) {
                    g = Arrays.copyOf(g, g.length * 2);
                    for (int k = cap; k < g.length; k++) g[k] = new ArrayList<>();
                    cap = g.length;
                }
                // 입력 형식: (target, m, src1..srcm) => src -> target
                g[sid].add(tid);
            }
        }

        String query = fs.next();
        int qid = getId(query);
        if (qid >= g.length) {
            g = Arrays.copyOf(g, g.length * 2);
            for (int k = cap; k < g.length; k++) g[k] = new ArrayList<>();
        }

        int realV = idMap.size();

        // g를 realV 크기로 정리
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] graph = new ArrayList[realV];
        for (int i = 0; i < realV; i++) graph[i] = g[i];
        g = graph;

        // SCC
        tarjanInit(realV);
        for (int i = 0; i < realV; i++) {
            if (disc[i] == -1) dfs(i);
        }

        // SCC DAG 구성 (중복 간선 제거는 indegree/위상정렬 안정성을 위해)
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] sccAdj = new ArrayList[sccCnt];
        for (int i = 0; i < sccCnt; i++) sccAdj[i] = new ArrayList<>();
        int[] indeg = new int[sccCnt];

        HashSet<Long> seen = new HashSet<>();
        for (int u = 0; u < realV; u++) {
            int su = sccId[u];
            for (int v : g[u]) {
                int sv = sccId[v];
                if (su == sv) continue;
                long key = (((long) su) << 32) ^ (sv & 0xffffffffL);
                if (seen.add(key)) {
                    sccAdj[su].add(sv);
                    indeg[sv]++;
                }
            }
        }

        // 점수 (BigInteger로 안전 처리)
        BigInteger[] score = new BigInteger[realV];
        Arrays.fill(score, BigInteger.ONE);

        // SCC 위상정렬
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < sccCnt; i++) {
            if (indeg[i] == 0) dq.add(i);
        }

        while (!dq.isEmpty()) {
            int s = dq.poll();

            // 이 SCC 안의 모든 노드에서, 다른 SCC로 나가는 원래 간선들만 전파
            for (int u : sccNodeVec.get(s)) {
                BigInteger suScore = score[u];
                for (int v : g[u]) {
                    if (sccId[u] != sccId[v]) {
                        score[v] = score[v].add(suScore);
                    }
                }
            }

            for (int nxt : sccAdj[s]) {
                if (--indeg[nxt] == 0) dq.add(nxt);
            }
        }

        System.out.print(score[qid].toString());
    }
}