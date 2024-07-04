class Solution {
    public int solution(int a, int b) {
        // 두 정수를 문자열로 변환하여 이어 붙인 값을 구합니다.
        String ab = String.valueOf(a) + String.valueOf(b);
        String ba = String.valueOf(b) + String.valueOf(a);
        
        // 두 문자열을 정수로 변환하여 비교합니다.
        int abInt = Integer.parseInt(ab);
        int baInt = Integer.parseInt(ba);
        
        // 더 큰 값을 반환합니다. 같으면 abInt를 반환합니다.
        if (abInt >= baInt) {
            return abInt;
        } else {
            return baInt;
        }
    }
}
