import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Integer[] cranes = new Integer[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cranes[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        Integer[] boxes = new Integer[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            boxes[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cranes, (a, b) -> b - a);
        Arrays.sort(boxes, (a, b) -> b - a);

        if (boxes[0] > cranes[0]) {
            System.out.println(-1);
            return;
        }
        
        boolean[] moved = new boolean[M];
        int movedCount = 0;               
        int rounds = 0;                 

        while (movedCount < M) {
            int ci = 0; 
            for (int bi = 0; bi < M; bi++) {
                if (moved[bi]) continue;
                if (cranes[ci] >= boxes[bi]) {
                    moved[bi] = true;
                    ci++;
                    movedCount++;
                    if (ci == N) break; 
                }
            }
            rounds++;
        }
        
        System.out.println(rounds);
    }
}
