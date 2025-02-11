import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            a %= 10; // 마지막 자리만 필요

            // a가 0이면 항상 0번 컴퓨터
            if (a == 0) {
                sb.append(10).append("\n");
                continue;
            }

            // 주기 찾기
            List<Integer> cycle = new ArrayList<>();
            int value = a;
            while (!cycle.contains(value)) {
                cycle.add(value);
                value = (value * a) % 10;
            }

            // b를 주기의 길이로 나눈 나머지(인덱스)를 활용
            int index = (b - 1) % cycle.size();
            sb.append(cycle.get(index)).append("\n");
        }

        System.out.println(sb);
    }
}
