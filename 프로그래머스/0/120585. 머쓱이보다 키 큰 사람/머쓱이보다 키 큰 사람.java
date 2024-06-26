class Solution {
    public int solution(int[] array, int height) {
        int answer = 0;
        
        // 배열을 순회하면서 각 요소를 확인합니다.
        for (int i = 0; i < array.length; i++) {
            // 현재 요소가 머쓱이의 키보다 크다면 카운터를 증가시킵니다.
            if (array[i] > height) {
                answer++;
            }
        }
        
        return answer;
    }
}