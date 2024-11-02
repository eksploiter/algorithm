import java.util.*;

public class Solution {
	public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
        int T = 10;
    	for (int i = 1; i <= 10; i++) {
        	scanner.nextLine();
            String pat = scanner.nextLine().trim();
            String txt = scanner.nextLine().trim();
            System.out.println("#" + i + " " + brF(txt, pat)); 
        }
        scanner.close();
    }
    public static int brF(String txt, String pat) {
    	int count = 0;
        for (int i = 0; i <= txt.length() - pat.length(); i++) {
        	boolean found = true;
            for (int j = 0; j < pat.length(); j++) {
            	if (txt.charAt(i + j) != pat.charAt(j)) {
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