import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 숫자 이름과 숫자를 매핑하기 위한 배열 및 맵
        String[] numberWords = {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};
        Map<String, Integer> wordToNumber = new HashMap<>();
        for (int i = 0; i < numberWords.length; i++) {
            wordToNumber.put(numberWords[i], i);
        }

        int testCases = Integer.parseInt(br.readLine().trim());
        StringBuilder result = new StringBuilder();

        for (int t = 1; t <= testCases; t++) {
            String[] header = br.readLine().split(" ");
            int wordCount = Integer.parseInt(header[1]);

            // 각 단어의 개수를 저장하는 배열
            int[] count = new int[10];

            // 입력 데이터를 읽어서 단어의 빈도를 계산
            String[] words = br.readLine().split(" ");
            for (String word : words) {
                count[wordToNumber.get(word)]++;
            }

            // 테스트 케이스 결과를 저장
            result.append("#").append(t).append("\n");
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < count[i]; j++) {
                    result.append(numberWords[i]).append(" ");
                }
            }
            result.append("\n");
        }

        // 최종 결과 출력
        System.out.print(result.toString());
    }
}
