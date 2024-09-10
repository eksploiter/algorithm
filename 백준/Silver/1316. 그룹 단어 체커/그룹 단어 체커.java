import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 단어의 개수 입력 받기
        int n = scanner.nextInt();
        int groupWordCount = 0;

        // 각 단어에 대해 그룹 단어인지 확인
        for (int i = 0; i < n; i++) {
            String word = scanner.next();
            if (isGroupWord(word)) {
                groupWordCount++;
            }
        }

        // 그룹 단어의 개수 출력
        System.out.println(groupWordCount);
    }

    // 그룹 단어인지 확인하는 함수
    private static boolean isGroupWord(String word) {
        boolean[] seen = new boolean[26]; // 알파벳 소문자의 사용 여부를 기록하는 배열
        char prevChar = '\0'; // 이전 문자를 기록하는 변수
        
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            
            if (currentChar != prevChar) {
                if (seen[currentChar - 'a']) {
                    return false; // 이미 등장한 문자가 다시 나타났지만 연속적이지 않음
                }
                seen[currentChar - 'a'] = true; // 현재 문자를 본 것으로 기록
            }
            
            prevChar = currentChar; // 현재 문자를 이전 문자로 업데이트
        }
        
        return true; // 그룹 단어임
    }
}
