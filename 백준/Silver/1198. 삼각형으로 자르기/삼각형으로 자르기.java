import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] pts = new long[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            pts[i][0] = Long.parseLong(st.nextToken());
            pts[i][1] = Long.parseLong(st.nextToken());
        }
        long bestTwiceArea = 0;
        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    long area2 = Math.abs(
                        pts[i][0] * pts[j][1] + pts[j][0] * pts[k][1] + pts[k][0] * pts[i][1]
                      - pts[j][0] * pts[i][1] - pts[k][0] * pts[j][1] - pts[i][0] * pts[k][1]
                    );
                    if (area2 > bestTwiceArea) bestTwiceArea = area2;
                }
            }
        }
        if (bestTwiceArea % 2 == 0) {
            System.out.println((bestTwiceArea / 2) + ".0");
        } else {
            System.out.println((bestTwiceArea / 2) + ".5");
        }
    }
}
