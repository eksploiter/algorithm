import java.io.*;
import java.util.*;

public class Main {
    static class Point {
        int x, y, d;
        Point(int x, int y, int d) { this.x = x; this.y = y; this.d = d; }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map.computeIfAbsent(y, k -> new ArrayList<>()).add(x);
        }
        for (List<Integer> ls : map.values()) {
            Collections.sort(ls);
        }

        Queue<Point> q = new ArrayDeque<>();
        q.add(new Point(0, 0, 0));

        int ans = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            Point p = q.poll();
            if (p.y >= T) {
                ans = Math.min(ans, p.d);
                continue;
            }
            for (int ny = p.y - 2; ny <= p.y + 2; ny++) {
                List<Integer> list = map.get(ny);
                if (list == null || list.isEmpty()) continue;

                int lo = Collections.binarySearch(list, p.x - 2);
                if (lo < 0) lo = -lo - 1;
                int idx = lo;
                while (idx < list.size()) {
                    int nx = list.get(idx);
                    if (nx > p.x + 2) break;
                    q.add(new Point(nx, ny, p.d + 1));
                    idx++;
                }
                list.subList(lo, idx).clear();
            }
        }

        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }
}
