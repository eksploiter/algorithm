import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] size = new int[6];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            size[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int tSum = 0;

        for (int i = 0; i < 6; i++) {
            tSum += size[i] / T;
            if (size[i] % T != 0) {
                tSum += 1;
            }
        }

        int penM = N / P;
        int penJ = N % P;

        System.out.println(tSum);
        System.out.println(penM + " " + penJ);
    }
}