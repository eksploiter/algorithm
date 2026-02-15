import java.io.*;
import java.util.*;

/**
 * BOJ 4263 - Rectilinear polygon
 * 가능한 경우: 주어진 점들을 꼭짓점으로 하는 단순 직각다각형의 둘레 길이
 * 불가능: -1
 */
public class Main {

    // ---------- Fast Scanner ----------
    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream in) { this.in = in; }

        private int readByte() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c;
            do { c = readByte(); } while (c <= ' ');

            int sign = 1;
            if (c == '-') { sign = -1; c = readByte(); }

            int val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = readByte();
            }
            return val * sign;
        }
    }

    // ---------- DSU ----------
    static class DSU {
        int[] p, r;
        DSU(int n) {
            p = new int[n];
            r = new int[n];
            for (int i = 0; i < n; i++) p[i] = i;
        }
        int find(int a) {
            while (p[a] != a) {
                p[a] = p[p[a]];
                a = p[a];
            }
            return a;
        }
        void union(int a, int b) {
            a = find(a); b = find(b);
            if (a == b) return;
            if (r[a] < r[b]) { int t = a; a = b; b = t; }
            p[b] = a;
            if (r[a] == r[b]) r[a]++;
        }
    }

    // ---------- Fenwick ----------
    static class Fenwick {
        int n;
        int[] bit;
        Fenwick(int n) { this.n = n; bit = new int[n + 1]; }
        void add(int i, int delta) {
            for (; i <= n; i += i & -i) bit[i] += delta;
        }
        int sum(int i) {
            int s = 0;
            for (; i > 0; i -= i & -i) s += bit[i];
            return s;
        }
        int rangeSum(int l, int r) {
            if (l > r) return 0;
            return sum(r) - sum(l - 1);
        }
    }

    static class PointRef {
        int coord; // y for x-group, x for y-group
        int idx;
        PointRef(int coord, int idx) { this.coord = coord; this.idx = idx; }
    }

    static class HSeg {
        int x1, x2;
        int y;
        int yIdx; // compressed y index (1-based)
        HSeg(int x1, int x2, int y) {
            this.x1 = x1; this.x2 = x2; this.y = y;
        }
    }

    static long pack(int x, int y) {
        // 좌표 범위가 int라 가정하고 64-bit로 유니크하게
        return (((long) x) << 32) ^ (y & 0xffffffffL);
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        StringBuilder out = new StringBuilder();

        int T = fs.nextInt();
        while (T-- > 0) {
            int n = fs.nextInt();

            int[] xs = new int[n];
            int[] ys = new int[n];

            // 중복 점 체크
            HashSet<Long> seen = new HashSet<>(n * 2);
            boolean ok = true;
            for (int i = 0; i < n; i++) {
                int x = fs.nextInt();
                int y = fs.nextInt();
                xs[i] = x; ys[i] = y;
                long key = pack(x, y);
                if (!seen.add(key)) ok = false;
            }

            if (!ok) {
                out.append("-1\n");
                continue;
            }

            // x -> list(y, idx)
            HashMap<Integer, ArrayList<PointRef>> byX = new HashMap<>();
            // y -> list(x, idx)
            HashMap<Integer, ArrayList<PointRef>> byY = new HashMap<>();

            int[] allY = new int[n];
            for (int i = 0; i < n; i++) {
                byX.computeIfAbsent(xs[i], k -> new ArrayList<>()).add(new PointRef(ys[i], i));
                byY.computeIfAbsent(ys[i], k -> new ArrayList<>()).add(new PointRef(xs[i], i));
                allY[i] = ys[i];
            }

            DSU dsu = new DSU(n);
            long perimeter = 0;

            // 수직 세그먼트 교차 체크용: (x, y1, y2)만 있으면 됨
            // 저장은 x별로 y-구간들 모아두기
            HashMap<Integer, ArrayList<int[]>> verticalAtX = new HashMap<>();

            // 1) x 그룹: y 정렬 후 연속 페어링
            for (Map.Entry<Integer, ArrayList<PointRef>> e : byX.entrySet()) {
                ArrayList<PointRef> list = e.getValue();
                if ((list.size() & 1) == 1) { ok = false; break; }
                list.sort(Comparator.comparingInt(a -> a.coord)); // coord = y

                int x = e.getKey();
                for (int i = 0; i < list.size(); i += 2) {
                    PointRef a = list.get(i);
                    PointRef b = list.get(i + 1);
                    int y1 = a.coord, y2 = b.coord;
                    dsu.union(a.idx, b.idx);
                    perimeter += Math.abs((long) y2 - y1);

                    int lo = Math.min(y1, y2);
                    int hi = Math.max(y1, y2);
                    verticalAtX.computeIfAbsent(x, k -> new ArrayList<>()).add(new int[]{lo, hi});
                }
            }

            if (!ok) {
                out.append("-1\n");
                continue;
            }

            // 수평 세그먼트 목록 생성
            HSeg[] horizontals = new HSeg[n / 2]; // 총 수평변 수 = n/2
            int hCnt = 0;

            // 2) y 그룹: x 정렬 후 연속 페어링
            for (Map.Entry<Integer, ArrayList<PointRef>> e : byY.entrySet()) {
                ArrayList<PointRef> list = e.getValue();
                if ((list.size() & 1) == 1) { ok = false; break; }
                list.sort(Comparator.comparingInt(a -> a.coord)); // coord = x

                int y = e.getKey();
                for (int i = 0; i < list.size(); i += 2) {
                    PointRef a = list.get(i);
                    PointRef b = list.get(i + 1);
                    int x1 = a.coord, x2 = b.coord;
                    dsu.union(a.idx, b.idx);
                    perimeter += Math.abs((long) x2 - x1);

                    int lo = Math.min(x1, x2);
                    int hi = Math.max(x1, x2);
                    horizontals[hCnt++] = new HSeg(lo, hi, y);
                }
            }

            if (!ok) {
                out.append("-1\n");
                continue;
            }

            // 3) 단일 사이클(단일 컴포넌트) 체크
            int root = dsu.find(0);
            for (int i = 1; i < n; i++) {
                if (dsu.find(i) != root) { ok = false; break; }
            }
            if (!ok) {
                out.append("-1\n");
                continue;
            }

            // 4) 내부 교차 체크 (스위프 + Fenwick)
            // y 좌표 압축
            Arrays.sort(allY);
            int m = 0;
            for (int i = 0; i < n; i++) {
                if (i == 0 || allY[i] != allY[i - 1]) allY[m++] = allY[i];
            }
            for (int i = 0; i < hCnt; i++) {
                int y = horizontals[i].y;
                int pos = Arrays.binarySearch(allY, 0, m, y);
                horizontals[i].yIdx = pos + 1; // Fenwick 1-based
            }
            Fenwick fw = new Fenwick(m);

            // 스위프 x 리스트(유니크)
            int[] uniqueX = Arrays.copyOf(xs, n);
            Arrays.sort(uniqueX);
            int xu = 0;
            for (int i = 0; i < n; i++) {
                if (i == 0 || uniqueX[i] != uniqueX[i - 1]) uniqueX[xu++] = uniqueX[i];
            }

            // 수평 세그먼트: 시작/끝 포인터
            HSeg[] byStart = Arrays.copyOf(horizontals, hCnt);
            HSeg[] byEnd = Arrays.copyOf(horizontals, hCnt);
            Arrays.sort(byStart, Comparator.comparingInt(a -> a.x1));
            Arrays.sort(byEnd, Comparator.comparingInt(a -> a.x2));
            int ps = 0, pe = 0;

            for (int xi = 0; xi < xu && ok; xi++) {
                int x = uniqueX[xi];

                // (open interval) 끝점에서는 활성 아님 -> 제거 먼저
                while (pe < hCnt && byEnd[pe].x2 == x) {
                    fw.add(byEnd[pe].yIdx, -1);
                    pe++;
                }

                // 현재 x에서 수직 세그먼트들 검사
                ArrayList<int[]> vlist = verticalAtX.get(x);
                if (vlist != null) {
                    for (int[] seg : vlist) {
                        int y1 = seg[0], y2 = seg[1];
                        if (y1 + 1 > y2 - 1) continue; // 내부가 없음

                        // (y1, y2) 내부의 활성 수평선 존재 여부
                        int l = upperIndex(allY, m, y1); // first > y1
                        int r = lowerIndex(allY, m, y2) - 1; // last < y2

                        if (l <= r) {
                            int cnt = fw.rangeSum(l + 1, r + 1); // to 1-based
                            if (cnt > 0) { ok = false; break; }
                        }
                    }
                }

                // (open interval) 시작점에서는 활성 아님 -> 추가는 마지막
                while (ps < hCnt && byStart[ps].x1 == x) {
                    fw.add(byStart[ps].yIdx, +1);
                    ps++;
                }
            }

            out.append(ok ? perimeter : -1).append('\n');
        }

        System.out.print(out);
    }

    // first index with arr[idx] > val in sorted arr[0..m)
    static int upperIndex(int[] arr, int m, int val) {
        int l = 0, r = m;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (arr[mid] <= val) l = mid + 1;
            else r = mid;
        }
        return l;
    }

    // first index with arr[idx] >= val in sorted arr[0..m)
    static int lowerIndex(int[] arr, int m, int val) {
        int l = 0, r = m;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (arr[mid] < val) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}
