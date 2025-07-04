import java.io.*;
import java.util.*;

public class Main {
    static final String[] DIGITS = {
        "###" + //0
        "#.#" +
        "#.#" +
        "#.#" +
        "###",
        "..#" + //1
        "..#" +
        "..#" +
        "..#" +
        "..#",
        "###" + //2
        "..#" +
        "###" +
        "#.." +
        "###",
        "###" + //3
        "..#" +
        "###" +
        "..#" +
        "###",
        "#.#" + //4
        "#.#" +
        "###" +
        "..#" +
        "..#",
        "###" + //5
        "#.." +
        "###" +
        "..#" +
        "###",
        "###" + //6
        "#.." +
        "###" +
        "#.#" +
        "###",
        "###" + //7
        "..#" +
        "..#" +
        "..#" +
        "..#",
        "###" + //8
        "#.#" +
        "###" +
        "#.#" +
        "###",
        "###" + //9
        "#.#" +
        "###" +
        "..#" +
        "###"
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] screen = new String[5];
        for(int i = 0; i < 5; i++) screen[i] = br.readLine();

        List<Integer>[] candidates = new ArrayList[N];
        for(int pos = 0; pos < N; pos++) {
            candidates[pos] = new ArrayList<>();
            for(int d = 0; d <= 9; d++) {
                if(canMatch(pos, d, screen)) {
                    candidates[pos].add(d);
                }
            }
            if(candidates[pos].isEmpty()) {
                System.out.println(-1);
                return;
            }
        }

        long totalWays = 1;
        for(int pos = 0; pos < N; pos++) {
            totalWays *= candidates[pos].size();
        }

        double totalSum = 0.0;
        for(int pos = 0; pos < N; pos++) {
            int size = candidates[pos].size();
            long sumDigits = 0;
            for(int d : candidates[pos]) sumDigits += d;

            long waysExcl = totalWays / size;
            double place = Math.pow(10, N - pos - 1);
            totalSum += sumDigits * waysExcl * place;
        }

        System.out.printf("%.5f\n", totalSum / totalWays);
    }

    private static boolean canMatch(int pos, int d, String[] screen) {
        String pattern = DIGITS[d];
        for(int r = 0; r < 5; r++) {
            for(int c = 0; c < 3; c++) {
                char target = screen[r].charAt(pos * 4 + c);
                char pat = pattern.charAt(r * 3 + c);
                if(target == '#' && pat == '.') return false;
            }
        }
        return true;
    }
}
