import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        int size = (int)(max - min + 1);
        boolean[] bad = new boolean[size]; // 제곱수로 나누어떨어지면 true

        long limit = (long)Math.sqrt(max);

        for (long i = 2; i <= limit; i++) {
            long sq = i * i;

            // min 이상에서 sq의 배수 중 첫 번째 값
            long start = (min + sq - 1) / sq * sq;

            for (long v = start; v <= max; v += sq) {
                bad[(int)(v - min)] = true;
            }
        }

        long count = 0;
        for (int i = 0; i < size; i++) {
            if (!bad[i]) count++;
        }

        System.out.print(count);
    }
}
