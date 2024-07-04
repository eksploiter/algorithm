class Solution {
    public int solution(int a, int b, int c) {
        int answer = 0;
        
        // Case 1: All three numbers are different
        if (a != b && b != c && a != c) {
            answer = a + b + c;
        }
        // Case 2: Two numbers are the same, and one is different
        else if (a == b && b != c) {
            answer = (a + b + c) * (a * a + b * b + c * c);
        } else if (a == c && b != c) {
            answer = (a + b + c) * (a * a + b * b + c * c);
        } else if (b == c && a != b) {
            answer = (a + b + c) * (a * a + b * b + c * c);
        }
        // Case 3: All three numbers are the same
        else {
            answer = (a + b + c) * (a * a + b * b + c * c) * (a * a * a + b * b * b + c * c * c);
        }
        
        return answer;
    }
}
