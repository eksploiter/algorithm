import java.util.*;

public class Solution {
    
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
        
        int T = 10;
        
    	for (int i = 1; i <= T; i++) {
            int caseNum = scanner.nextInt();
            scanner.nextLine(); // 개행문자 처리
            String pattern = scanner.nextLine().trim();
        	String text = scanner.nextLine().trim();
            int result = bruteForce(pattern, text);
        	System.out.println("#" + caseNum + " " + result);
        }
        
        scanner.close();
    }
    
    public static int bruteForce(String pattern, String text) {
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