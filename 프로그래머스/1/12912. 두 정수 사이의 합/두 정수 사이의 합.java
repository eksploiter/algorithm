class Solution {
    public long solution(int a, int b) {
        long sum = 0;
        
        // a와 b의 대소 관계를 파악하여 작은 값을 start에, 큰 값을 end에 저장합니다.
        int start = Math.min(a, b);
        int end = Math.max(a, b);
        
        // start부터 end까지 모든 정수를 더합니다.
        for (int i = start; i <= end; i++) {
            sum += i;
        }
        
        return sum;
    }
}
