import java.util.*;

public class Solution {
	public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
        
        int T = 10;
        for (int i = 1; i <= T; i++) {
        	scanner.nextLine();
            String pattern = scanner.nextLine();
            String text = scanner.nextLine();
            System.out.println("#" + i + " " + bruteForce(text, pattern));
        }
        scanner.close();
    }
    public static int bruteForce(String text, String pattern) {
    	int count = 0;
        for (int i = 0; i <= text.length() - pattern.length(); i++) {
        	boolean found = true;
            for (int j = 0; j < pattern.length(); j++) {
            	if (text.charAt(i + j) != pattern.charAt(j)) {
                	found = false;
                    break;
                }
            }
            if (found) {
            	count++;
            }
        }
        return count;
    }
}