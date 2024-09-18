import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String S = scanner.nextLine();
        
        int[] word = new int[26];
        
        for (int i = 0; i < 26; i++) {
            word[i] = -1;
        }
        
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            int index = ch - 'a';
            
            if (word[index] == -1) {
                word[index] = i;
            }
        }
        
        for (int i = 0; i < 26; i++) {
            System.out.print(word[i] + " ");
        }
    }
}