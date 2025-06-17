import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    static int[] size;

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static int union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
            size[a] += size[b];
        }
        return size[a];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int F = Integer.parseInt(br.readLine());
            parent = new int[2 * F];
            size = new int[2 * F];
            for (int i = 0; i < 2 * F; i++) {
                parent[i] = i;
                size[i] = 1;
            }

            Map<String, Integer> map = new HashMap<>(2 * F);
            int nextId = 0;

            for (int i = 0; i < F; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String s1 = st.nextToken();
                String s2 = st.nextToken();

                map.putIfAbsent(s1, nextId++);
                map.putIfAbsent(s2, nextId++);

                int id1 = map.get(s1);
                int id2 = map.get(s2);

                int result = union(id1, id2);
                sb.append(result).append('\n');
            }
        }
        System.out.print(sb);
    }
}
