import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            
            int n = Integer.parseInt(br.readLine());
            int count = 0;

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int cx = Integer.parseInt(st.nextToken());
                int cy = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());

                long dx1 = x1 - cx, dy1 = y1 - cy;
                long dx2 = x2 - cx, dy2 = y2 - cy;

                boolean startInside = dx1 * dx1 + dy1 * dy1 < (long)r * r;
                boolean endInside   = dx2 * dx2 + dy2 * dy2 < (long)r * r;

                if (startInside ^ endInside) {
                    count++;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb.toString());
    }
}
