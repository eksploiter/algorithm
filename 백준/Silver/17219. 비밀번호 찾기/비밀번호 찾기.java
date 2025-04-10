import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 저장할 사이트 수
        int M = Integer.parseInt(st.nextToken()); // 찾을 사이트 수

        Map<String, String> passwordMap = new HashMap<>();

        // N개의 사이트 주소와 비밀번호 저장
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String site = st.nextToken();
            String password = st.nextToken();
            passwordMap.put(site, password);
        }

        // M개의 사이트 주소에 대한 비밀번호 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String querySite = br.readLine();
            sb.append(passwordMap.get(querySite)).append('\n');
        }

        System.out.print(sb.toString());
    }
}
