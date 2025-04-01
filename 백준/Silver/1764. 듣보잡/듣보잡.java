import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 빠르게 받기 위한 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 듣도 못한 사람 수
        int M = Integer.parseInt(st.nextToken()); // 보도 못한 사람 수

        Set<String> unheard = new HashSet<>();
        List<String> result = new ArrayList<>();

        // 듣도 못한 사람들 저장
        for (int i = 0; i < N; i++) {
            unheard.add(br.readLine());
        }

        // 보도 못한 사람들 중에서 듣도 못한 사람과 겹치는 경우 찾기
        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            if (unheard.contains(name)) {
                result.add(name);
            }
        }

        // 사전 순 정렬
        Collections.sort(result);

        // 결과 출력
        System.out.println(result.size());
        for (String name : result) {
            System.out.println(name);
        }
    }
}
