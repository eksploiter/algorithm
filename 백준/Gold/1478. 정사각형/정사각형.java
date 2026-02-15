import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        int[] x1 = new int[N];
        int[] y1 = new int[N];
        int[] x2 = new int[N];
        int[] y2 = new int[N];

        ArrayList<Integer> xsList = new ArrayList<>();
        ArrayList<Integer> ysList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            // 좌하단/우상단 정규화
            int lx = Math.min(a, c), rx = Math.max(a, c);
            int by = Math.min(b, d), ty = Math.max(b, d);

            x1[i] = lx; y1[i] = by; x2[i] = rx; y2[i] = ty;

            xsList.add(lx); xsList.add(rx);
            ysList.add(by); ysList.add(ty);
        }

        int[] xs = compress(xsList);
        int[] ys = compress(ysList);

        int nx = xs.length;
        int ny = ys.length;

        // 좌표 -> 인덱스
        HashMap<Integer, Integer> xIdx = new HashMap<>();
        HashMap<Integer, Integer> yIdx = new HashMap<>();
        for (int i = 0; i < nx; i++) xIdx.put(xs[i], i);
        for (int i = 0; i < ny; i++) yIdx.put(ys[i], i);

        // 작은 구간 단위 edge 존재 여부
        // hor[y][x] : (x,y) -> (x+1,y), y:0..ny-1, x:0..nx-2
        boolean[][] hor = new boolean[ny][Math.max(0, nx - 1)];
        // ver[y][x] : (x,y) -> (x,y+1), y:0..ny-2, x:0..nx-1
        boolean[][] ver = new boolean[Math.max(0, ny - 1)][nx];

        // 직사각형 테두리 마킹
        for (int i = 0; i < N; i++) {
            int ix1 = xIdx.get(x1[i]);
            int ix2 = xIdx.get(x2[i]);
            int iy1 = yIdx.get(y1[i]);
            int iy2 = yIdx.get(y2[i]);

            // 아래/위 가로변
            for (int x = ix1; x < ix2; x++) {
                hor[iy1][x] = true;
                hor[iy2][x] = true;
            }
            // 왼/오 세로변
            for (int y = iy1; y < iy2; y++) {
                ver[y][ix1] = true;
                ver[y][ix2] = true;
            }
        }

        // 가로: 행별 prefix(없는 edge 개수 누적)
        int[][] missHor = new int[ny][nx]; // missHor[y][t] = 0..t-1까지 누적(가로 edge는 nx-1개)
        for (int y = 0; y < ny; y++) {
            for (int x = 0; x < nx - 1; x++) {
                missHor[y][x + 1] = missHor[y][x] + (hor[y][x] ? 0 : 1);
            }
        }

        // 세로: 열별 prefix(없는 edge 개수 누적)
        int[][] missVer = new int[nx][ny]; // missVer[x][t] = 0..t-1까지 누적(세로 edge는 ny-1개)
        for (int x = 0; x < nx; x++) {
            for (int y = 0; y < ny - 1; y++) {
                missVer[x][y + 1] = missVer[x][y] + (ver[y][x] ? 0 : 1);
            }
        }

        // y 좌표 값 -> 인덱스 (len 맞는 위쪽 y 찾기)
        HashMap<Integer, Integer> yPos = new HashMap<>();
        for (int i = 0; i < ny; i++) yPos.put(ys[i], i);

        long ans = 0;

        // 모든 x쌍 (i<j)
        for (int i = 0; i < nx; i++) {
            for (int j = i + 1; j < nx; j++) {
                int len = xs[j] - xs[i];
                if (len == 0) continue;

                // y에서 같은 길이 되는 (k,l) 검사
                for (int k = 0; k < ny; k++) {
                    int targetY = ys[k] + len;
                    Integer lObj = yPos.get(targetY);
                    if (lObj == null) continue;
                    int l = lObj;

                    // 4변이 전부 존재하는지 O(1) 체크 (구간에 missing edge가 0이어야 함)
                    // bottom: hor[k] 구간 [i, j)
                    if (missingHor(missHor, k, i, j) != 0) continue;
                    // top: hor[l] 구간 [i, j)
                    if (missingHor(missHor, l, i, j) != 0) continue;
                    // left: ver col i 구간 [k, l)
                    if (missingVer(missVer, i, k, l) != 0) continue;
                    // right: ver col j 구간 [k, l)
                    if (missingVer(missVer, j, k, l) != 0) continue;

                    ans++;
                }
            }
        }

        System.out.println(ans);
    }

    // [l, r) 구간의 "없는 가로 edge" 개수
    static int missingHor(int[][] missHor, int y, int l, int r) {
        return missHor[y][r] - missHor[y][l];
    }

    // [b, t) 구간의 "없는 세로 edge" 개수
    static int missingVer(int[][] missVer, int x, int b, int t) {
        return missVer[x][t] - missVer[x][b];
    }

    static int[] compress(ArrayList<Integer> list) {
        Collections.sort(list);
        int m = list.size();
        int[] tmp = new int[m];
        for (int i = 0; i < m; i++) tmp[i] = list.get(i);

        int[] uniq = new int[m];
        int sz = 0;
        for (int i = 0; i < m; i++) {
            if (i == 0 || tmp[i] != tmp[i - 1]) uniq[sz++] = tmp[i];
        }
        return Arrays.copyOf(uniq, sz);
    }
}
