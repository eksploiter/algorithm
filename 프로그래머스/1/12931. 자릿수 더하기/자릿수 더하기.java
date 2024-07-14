import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;

        // Convert the integer to a string to easily access its digits
        String a = String.valueOf(n);

        // Loop through each character in the string
        for (int i = 0; i < a.length(); i++) {
            // Convert the character to an integer and add it to the answer
            answer += Character.getNumericValue(a.charAt(i));
        }

        // Print the sum of the digits
        System.out.println(answer);

        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        // Test with a three-digit number
        System.out.println("Sum of digits: " + sol.solution(123)); // Output: Sum of digits: 6
    }
}
