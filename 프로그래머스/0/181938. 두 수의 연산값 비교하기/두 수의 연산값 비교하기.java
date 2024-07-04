class Solution {
    public int solution(int a, int b) {
        // 두 정수를 문자열로 변환하여 이어 붙인 값을 구합니다.
        String abString = String.valueOf(a) + String.valueOf(b);
        int ab = Integer.parseInt(abString);
        
        // 2 * a * b 값을 계산합니다.
        int product = 2 * a * b;
        
        // 두 값을 비교하여 더 큰 값을 반환합니다.
        if (ab >= product) {
            return ab;
        } else {
            return product;
        }
    }
}
