import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
        for (int t = 1; t <= 10; t++) {
        	scanner.nextLine();
            String pattern = scanner.nextLine().trim();
            String text = scanner.nextLine().trim();
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
            System.out.println("#" + t + " " + count); 
        }
        scanner.close();
    }
}