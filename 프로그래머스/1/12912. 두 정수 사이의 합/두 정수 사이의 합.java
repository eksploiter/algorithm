public class Solution {
    public long solution(int a, int b) {
        long sum = 0;

        int start = Math.min(a, b);
        int end = Math.max(a, b);

        for (int i = start; i <= end; i++) {
            sum += i;
        }

        return sum;
    }
}