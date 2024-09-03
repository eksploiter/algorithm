import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력받은 단어를 모두 대문자로 변환
        String word = scanner.nextLine().toUpperCase();

        // 알파벳 빈도를 저장할 배열 (A-Z는 26개의 알파벳)
        int[] frequency = new int[26];

        // 각 문자에 대해 빈도를 계산
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            frequency[ch - 'A']++;
        }

        // 가장 많이 사용된 알파벳 찾기
        int maxFrequency = -1;
        char mostFrequentChar = '?';
        for (int i = 0; i < 26; i++) {
            if (frequency[i] > maxFrequency) {
                maxFrequency = frequency[i];
                mostFrequentChar = (char) (i + 'A');
            } else if (frequency[i] == maxFrequency) {
                mostFrequentChar = '?';
            }
        }

        // 결과 출력
        System.out.println(mostFrequentChar);
    }
}
