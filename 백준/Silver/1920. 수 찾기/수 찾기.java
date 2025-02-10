import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // 첫 번째 정수 배열 입력
        int N = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        // 두 번째 정수 배열 입력
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        // 결과 출력
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            sb.append(set.contains(num) ? "1\n" : "0\n");
        }

        System.out.print(sb);
    }
}
