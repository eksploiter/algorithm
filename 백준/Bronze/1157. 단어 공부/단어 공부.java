import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String word = scanner.nextLine().toUpperCase();
        
        int[] freq = new int[26];
        
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            freq[ch - 'A']++;
        }
        
        int maxFreq = -1;
        char mostFreq = '?';
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > maxFreq) {
                maxFreq = freq[i];
                mostFreq = (char) (i + 'A');
            } else if (freq[i] == maxFreq) {
                mostFreq = '?';
            }
        }
        
        System.out.println(mostFreq);
    }
}