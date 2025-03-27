import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 빠른 입력을 위한 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 빠른 출력을 위한 StringBuilder
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); // 포켓몬 수
        int M = Integer.parseInt(input[1]); // 문제 수

        // 포켓몬 이름으로 번호를 찾는 Map
        Map<String, Integer> nameToNumber = new HashMap<>();
        // 번호로 포켓몬 이름을 찾는 배열
        String[] numberToName = new String[N + 1]; // 1번부터 시작

        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            nameToNumber.put(name, i);
            numberToName[i] = name;
        }

        for (int i = 0; i < M; i++) {
            String q = br.readLine();
            if (isNumber(q)) {
                int num = Integer.parseInt(q);
                sb.append(numberToName[num]).append("\n");
            } else {
                sb.append(nameToNumber.get(q)).append("\n");
            }
        }

        System.out.print(sb);
    }

    // 문자열이 숫자인지 판별하는 함수
    private static boolean isNumber(String s) {
        return s.charAt(0) >= '0' && s.charAt(0) <= '9';
    }
}
