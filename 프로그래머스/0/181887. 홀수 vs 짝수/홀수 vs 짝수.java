class Solution {
    public int solution(int[] num_list) {
        int oddSum = 0;  // 홀수 번째 원소들의 합
        int evenSum = 0; // 짝수 번째 원소들의 합
        
        for (int i = 0; i < num_list.length; i++) {
            if ((i + 1) % 2 == 1) {
                // 인덱스 i+1이 홀수인 경우
                oddSum += num_list[i];
            } else {
                // 인덱스 i+1이 짝수인 경우
                evenSum += num_list[i];
            }
        }
        
        // 홀수 번째 원소들의 합과 짝수 번째 원소들의 합 중 큰 값을 반환
        return Math.max(oddSum, evenSum);
    }
}
