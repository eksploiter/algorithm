import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[][] square = new int[n][m];
        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < m; j++) {
                square[i][j] = row.charAt(j) - '0';
            }
        }
        
        int maxSide = Math.min(n, m);
        int answer = 1;
        
        for (int len = 2; len <= maxSide; len++) {
            for (int i = 0; i <= n - len; i++) {
                for (int j = 0; j <= m - len; j++) {
                    int v = square[i][j];
                    if (v == square[i][j + len - 1] &&
                        v == square[i + len - 1][j] &&
                        v == square[i + len - 1][j + len - 1]) {
                        answer = Math.max(answer, len * len);
                    }
                }
            }
        }
        
        System.out.println(answer);
    }
}
