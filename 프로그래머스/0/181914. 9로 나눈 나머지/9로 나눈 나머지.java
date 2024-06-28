class Solution {
    public int solution(String number) {
        int answer = 0;
        
        // 문자열의 각 문자를 숫자로 변환하여 합을 구합니다.
        for (int i = 0; i < number.length(); i++) {
            answer += Character.getNumericValue(number.charAt(i));
        }
        
        // 합을 9로 나눈 나머지를 반환합니다.
        return answer % 9;
    }
}