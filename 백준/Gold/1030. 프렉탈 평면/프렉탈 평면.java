import java.io.*;
import java.util.*;

public class Main {
    static int s, N, K;
    static long[] powN; // powN[i] = N^i

    static boolean isBlack(long r, long c) {
        long size = powN[s];          // 현재 정사각형 한 변 길이
        int start = (N - K) / 2;      // 가운데 검정 블록 시작 인덱스 (0~N-1)
        int end = start + K - 1;      // 끝 인덱스

        for (int level = 0; level < s; level++) {
            size /= N; // 다음 단계 블록 한 변 길이

            long br = r / size; // 현재 단계에서 r이 속한 블록 행 (0~N-1)
            long bc = c / size; // 현재 단계에서 c가 속한 블록 열 (0~N-1)

            if (br >= start && br <= end && bc >= start && bc <= end) {
                return true; // 이 단계에서 가운데 KxK면 검정 확정
            }

            // 하위 블록 좌표로 축소
            r %= size;
            c %= size;
        }
        return false; // 끝까지 가운데에 안 걸리면 흰색
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        s = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        long r1 = Long.parseLong(st.nextToken());
        long r2 = Long.parseLong(st.nextToken());
        long c1 = Long.parseLong(st.nextToken());
        long c2 = Long.parseLong(st.nextToken());

        powN = new long[s + 1];
        powN[0] = 1;
        for (int i = 1; i <= s; i++) powN[i] = powN[i - 1] * N;

        StringBuilder out = new StringBuilder();
        for (long r = r1; r <= r2; r++) {
            for (long c = c1; c <= c2; c++) {
                out.append(isBlack(r, c) ? '1' : '0');
            }
            out.append('\n');
        }

        System.out.print(out);
    }
}
