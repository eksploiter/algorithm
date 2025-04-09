import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[] N = new int[A];
        int[] M = new int[B];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A; i++) {
            N[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < B; i++) {
            M[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N.length; i++) {
            list.add(N[i]);
        }
        for (int i = 0; i < M.length; i++) {
            list.add(M[i]);
        }

        Integer[] merged = list.toArray(new Integer[0]);

        Arrays.sort(merged);

        StringBuilder sb = new StringBuilder();
        for (int num : merged) {
            sb.append(num).append(" ");
        }

        System.out.println(sb);
    }
}
