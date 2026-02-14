import java.io.*;
import java.util.*;

public class Main {

    static class Word {
        int[] cnt = new int[26];
        int mask; // 단어에 포함된 알파벳 비트마스크(빠른 필터용)
        Word(String s) {
            int m = 0;
            for (int i = 0; i < s.length(); i++) {
                int idx = s.charAt(i) - 'A';
                cnt[idx]++;
                m |= (1 << idx);
            }
            mask = m;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1) 단어 입력
        ArrayList<Word> dict = new ArrayList<>();
        while (true) {
            String line = br.readLine();
            if (line.equals("-")) break;
            dict.add(new Word(line.trim()));
        }

        StringBuilder out = new StringBuilder();

        // 2) 퍼즐 처리
        while (true) {
            String puzzle = br.readLine();
            if (puzzle.equals("#")) break;
            puzzle = puzzle.trim();

            int[] pcnt = new int[26];
            int pmask = 0;
            for (int i = 0; i < puzzle.length(); i++) {
                int idx = puzzle.charAt(i) - 'A';
                pcnt[idx]++;
                pmask |= (1 << idx);
            }

            int[] appear = new int[26]; // 각 알파벳이 가능한 단어들에 몇 번(단어 단위로) 등장했는지

            // 모든 단어 검사
            for (Word w : dict) {
                // 빠른 필터: 단어의 알파벳 집합이 퍼즐 집합의 부분집합이어야 함
                if ((w.mask & ~pmask) != 0) continue;

                // 개수 제한 검사
                boolean ok = true;
                for (int i = 0; i < 26; i++) {
                    if (w.cnt[i] > pcnt[i]) { ok = false; break; }
                }
                if (!ok) continue;

                // 가능한 단어면: 포함된 알파벳들에 대해 등장 카운트 증가
                int m = w.mask;
                while (m != 0) {
                    int b = m & -m;
                    int idx = Integer.numberOfTrailingZeros(b);
                    appear[idx]++;
                    m -= b;
                }
            }

            // 퍼즐에 존재하는 알파벳만 대상으로 min/max 찾기
            int min = Integer.MAX_VALUE, max = -1;
            for (int i = 0; i < 26; i++) {
                if (pcnt[i] == 0) continue;
                min = Math.min(min, appear[i]);
                max = Math.max(max, appear[i]);
            }

            // min/max 알파벳들 모으기(사전순)
            StringBuilder mins = new StringBuilder();
            StringBuilder maxs = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (pcnt[i] == 0) continue;
                if (appear[i] == min) mins.append((char)('A' + i));
                if (appear[i] == max) maxs.append((char)('A' + i));
            }

            out.append(mins).append(" ").append(min).append(" ")
               .append(maxs).append(" ").append(max).append("\n");
        }

        System.out.print(out.toString());
    }
}
