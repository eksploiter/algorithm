import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String word = scanner.nextLine().toUpperCase();
        
        int[] freq = new int[26]; // AAB
        
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            freq[ch - 'A']++;
        }
        
        // 1. A -> 0
        // 2. A -> 0 // ++ 이므로 1
        // 3. B -> 1 // ++ 이므로 0
        
        // int[26] freq = {1, 0, -1, -1, ...}
        
        int maxFreq = -1; // 어떠한 알파벳도 고려되지 않음
        char mostFreqChar = '?'; // 초가 값
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > maxFreq) {
                maxFreq = freq[i]; // maxFreq = 1
                mostFreqChar = (char) (i + 'A'); // 정수형에서 문자형으로 형변환 -> A
            } else if (freq[i] == maxFreq) { // 더이상 겹치는 값이 없다.
                mostFreqChar = '?';
            }
        }
        
        System.out.println(mostFreqChar);
    }
}