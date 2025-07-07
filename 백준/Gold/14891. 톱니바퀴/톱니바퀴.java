import java.io.*;
import java.util.*;

public class Main {
    static String[] gears = new String[4];
    static int[] dir = new int[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 4; i++) {
            gears[i] = br.readLine();
        }
        int K = Integer.parseInt(br.readLine());
        while (K-- > 0) {
            Arrays.fill(dir, 0);
            StringTokenizer st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken());
            dir[g] = d;
            dfs(g, -1); // 왼쪽 방향 판단
            dfs(g, +1); // 오른쪽 방향 판단
            rotateAll();
        }

        int score = 0;
        for (int i = 0; i < 4; i++) {
            if (gears[i].charAt(0) == '1') {
                score += (1 << i);
            }
        }
        System.out.println(score);
    }
    
    static void dfs(int idx, int side) {
        int nei = idx + side;
        if (nei < 0 || nei >= 4 || dir[idx] == 0) return;
        if (side == -1) { // 왼쪽
            if (gears[idx].charAt(6) != gears[nei].charAt(2)) {
                dir[nei] = -dir[idx];
                dfs(nei, side);
            }
        } else { // 오른쪽
            if (gears[idx].charAt(2) != gears[nei].charAt(6)) {
                dir[nei] = -dir[idx];
                dfs(nei, side);
            }
        }
    }

    static void rotateAll() {
        for (int i = 0; i < 4; i++) {
            if (dir[i] == 0) continue;
            String s = gears[i];
            if (dir[i] == 1) { // 시계
                gears[i] = s.charAt(7) + s.substring(0, 7);
            } else { // 반시계
                gears[i] = s.substring(1) + s.charAt(0);
            }
        }
    }
}
