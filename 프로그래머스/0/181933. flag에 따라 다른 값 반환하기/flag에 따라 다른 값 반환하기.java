class Solution {
    public int solution(int a, int b, boolean flag) {
        // flag가 true이면 a와 b를 더한 값을 반환하고, 그렇지 않으면 a에서 b를 뺀 값을 반환합니다.
        if (flag) {
            return a + b;
        } else {
            return a - b;
        }
    }
}
